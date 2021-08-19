import java.io.*;
import java.text.*;
import java.util.*;

public class Scan {

    public static LinkedHashSet<Organization> parseFromXML(String filename) {
        final ArrayList<String> s = new ArrayList<>();
        final LinkedHashSet<Organization> listOfOrganization=new LinkedHashSet<>();
        Address postalAddress=new Address("");
        s.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            String line = "";
            while ((line = reader.readLine()) != null) {
                s.add(line);
            }

            for (int j=2; j<=s.size();j+=14){
                if(j+14>s.size()){
                    break;
                }

                Scanner scanner = new Scanner(s.get(j));
                String buffer = scanner.findInLine("\\d+");
                long id = Long.parseLong(buffer);


                scanner = new Scanner(s.get(j + 1));
                String name = scanner.findInLine("\\s\\w+");
                scanner = new Scanner(name);
                name = scanner.findInLine("\\w+");


                scanner = new Scanner(s.get(j + 3));
                buffer = scanner.findInLine("\\d+");
                long x = Long.parseLong(buffer);


                scanner = new Scanner(s.get(j + 4));
                buffer = scanner.findInLine("\\d+");
                double y = Double.parseDouble(buffer);

                scanner = new Scanner(s.get(j + 6));
                buffer = scanner.findInLine(" \\d+:\\d+:\\d+.\\d+ \\d+-\\d+-\\d+ ");
                Date creationDate = new SimpleDateFormat("HH:mm:ss.SSS dd-MM-yyyy").parse(buffer);


                scanner = new Scanner(s.get(j + 7));
                buffer = scanner.findInLine("\\d+");
                int annualTurnover = Integer.parseInt(buffer);

                scanner = new Scanner(s.get(j + 8));
                buffer = scanner.findInLine("\\s\\w+");
                scanner = new Scanner(buffer);
                String fullName = scanner.findInLine("\\w+");


                scanner = new Scanner(s.get(j + 9));
                buffer = scanner.findInLine("\\d+");
                long employeesCount = Long.parseLong(buffer);


                scanner = new Scanner(s.get(j + 10));
                OrganizationType type;
                if (buffer.equals(scanner.findInLine(" {4}</Organisation>")) || buffer.equals(scanner.findInLine("</Organisations>")) || buffer.equals(scanner.findInLine(" {8}<postalAddress> \\w* </postalAddress>"))) {
                    type = null;
                } else {
                    buffer = scanner.findInLine("\\s\\w+");
                    scanner = new Scanner(buffer);
                    buffer = scanner.findInLine("\\w+");
                    type =OrganizationType.valueOf(buffer);
                }

                scanner = new Scanner(s.get(j + 11));
                if (buffer.equals(scanner.findInLine(" {4}</Organisation>")) || buffer.equals(scanner.findInLine("</Organisations>"))) {
                    postalAddress = null;
                } else {
                    buffer = scanner.findInLine("\\s\\w+");
                    scanner = new Scanner(buffer);
                    buffer = scanner.findInLine("\\w+");
                    postalAddress.setZipCode(buffer);
                }
                Coordinates coordinates=new Coordinates(x,y);
                Organization organization = new Organization(id,name,coordinates,creationDate,annualTurnover, fullName, employeesCount, type, postalAddress);
                listOfOrganization.add(organization);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return listOfOrganization;
    }

    public static void parseToXML(LinkedHashSet<Organization> orgs, String filename) throws FileNotFoundException {
        FileOutputStream write = new FileOutputStream(filename);
        StringBuilder s = new StringBuilder("<Organizations>\n");
        try {
            for (Organization org :orgs) {
                s.append("    <Organization>\n" + "        <id> ").append(org.getId()).append(" </id>\n").append("        <name> ").append(org.getName()).append(" </name>\n").append("        <coordinates>\n").append("            <x> ").append(org.getСoordinates().getX()).append(" </x>\n").append("            <y> ").append(org.getСoordinates().getY()).append(" </y>\n").append("        </coordinates>\n").append("        <creationDate> ").append(new SimpleDateFormat("HH:mm:ss.SSS dd-MM-yyyy").format(org.getCreationDate())).append(" </creationDate>\n").append("        <annualTurnover> ").append(org.getAnnualTurnover()).append(" </annualTurnover>\n").append("        <fullName> ").append(org.getFullName()).append(" </fullName>\n").append("        <employeesCount> ").append(org.getEmployeesCount()).append(" </employeesCount>\n").append("        <type> ").append(org.getType()).append(" </type>\n").append("        <postalAddress> ").append(org.getPostalAddress()).append(" </postalAddress>\n").append("    </Organization>\n");
            }
            s.append("</Organizations>");
            byte[] data = s.toString().getBytes();
            write.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}