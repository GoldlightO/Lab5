import java.io.IOException;
import java.util.*;

public class AddIfMin {
    public static LinkedHashSet<Organization> addIfMin(LinkedHashSet <Organization> org, long id) throws IOException {
        ArrayList<Organization> tableValues = new ArrayList<Organization> (org);
        Comparator<Organization> ocomp= new OrganizationComporator.ComporatorByName().thenComparing(new OrganizationComporator.ComporatorByAnnualTurnover());
        Collections.sort(tableValues,ocomp);

        String name;
        Coordinates coordinates=new Coordinates(0, 0);
        java.util.Date creationDate=new Date();
        int annualTurnover;
        String fullName;
        Long employeesCount;
        OrganizationType type;
        String zipCode="A";
        Address postalAddress = new Address(zipCode);
        Scanner in = new Scanner(System.in);
        long newId = id;

        System.out.println("Введите имя: ");
        name=in.nextLine();
        System.out.println("Введите координату X: ");
        coordinates.setX(in.nextInt());
        System.out.println("Введите координату Y: ");
        coordinates.setX(in.nextInt());
        System.out.println("Введите годовой оборот: ");
        annualTurnover=in.nextInt();
        System.out.println("Введите полное имя: ");
        in.nextLine();
        fullName=in.nextLine();
        System.out.println("Введите количество сотрудников: ");
        employeesCount=in.nextLong();
        System.out.println("Введите тип организации (COMMERCIAL, TRUST, PRIVATE_LIMITED_COMPANY, OPEN_JOINT_STOCK_COMPANY): ");
        in.nextLine();
        type=OrganizationType.valueOf(in.nextLine());
        System.out.println("Введите почтовый адрес: ");
        zipCode=in.nextLine();
        postalAddress.setZipCode(zipCode);
        Organization organization = new Organization(newId,name,coordinates,creationDate,annualTurnover, fullName, employeesCount, type, postalAddress);
        for(Organization o:tableValues){
            if(o.getId() > newId){
                org.add(organization);
                break;
            }
        }
        return org;
    }
}
