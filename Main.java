import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean exit = false;
        LinkedHashSet organizations = Scan.parseFromXML("C:\\Lab5\\src\\Organizations.xml");
        String buffer;
        Scanner in = new Scanner(System.in);
        ArrayList<String> commands= new ArrayList<>();
        String filename = "C:\\Lab5\\src\\Organizations.xml";
        while (!exit) {
            System.out.print("Введите команду. (Чтобы вывести список команд, введите \"help\"): ");
            buffer = in.nextLine();
            Scanner scanner = new Scanner(buffer);
            String bufferIfer = scanner.findInLine("^\\S+");
            if (bufferIfer.equals("help") | bufferIfer.equals("info") | bufferIfer.equals("show") | bufferIfer.equals("add") | bufferIfer.equals("update") | bufferIfer.equals("remove_by_id") | bufferIfer.equals("clear") | bufferIfer.equals("save") | bufferIfer.equals("execute_script") | bufferIfer.equals("exit") | bufferIfer.equals("add_if_min") | bufferIfer.equals("remove_greater") | bufferIfer.equals("history") | bufferIfer.equals("remove_all_by_annual_turnover") | bufferIfer.equals("filter_less_than_postal_address") | bufferIfer.equals("filter_greater_than_postal_address")) {
                commands.add(bufferIfer);
                if(commands.size()>15){
                    commands.remove(0);
                }
            }
            DetermineCommand.command(buffer,organizations,commands, new ArrayList(), filename);
        }
    }
}