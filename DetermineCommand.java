import java.io.IOException;
import java.util.*;

public class DetermineCommand {
    public static LinkedHashSet<Organization> command(String command, LinkedHashSet<Organization> orgs, ArrayList<String> commands, ArrayList<String> previousFilenames, String filename, Date initializationDate) throws IOException {
        Scanner scanner = new Scanner(command);
        FilterPostalAddress address=new FilterPostalAddress();
        switch (command) {
            case "help":
                System.out.println("help : вывести справку по доступным командам\n" +
                        "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                        "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                        "add {element} : добавить новый элемент в коллекцию\n" +
                        "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                        "remove_by_id id : удалить элемент из коллекции по его id\n" +
                        "clear : очистить коллекцию\n" +
                        "save : сохранить коллекцию в файл\n" +
                        "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                        "exit : завершить программу (без сохранения в файл)\n" +
                        "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
                        "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
                        "history : вывести последние 15 команд (без их аргументов)\n" +
                        "remove_all_by_annual_turnover annualTurnover : удалить из коллекции все элементы, значение поля annualTurnover которого эквивалентно заданному\n" +
                        "filter_less_than_postal_address postalAddress : вывести элементы, значение поля postalAddress которых меньше заданного\n" +
                        "filter_greater_than_postal_address postalAddress : вывести элементы, значение поля postalAddress которых больше заданного");
                break;
            case "info":
                System.out.println("Тип коллекции: " + orgs.getClass());
                System.out.println("Кол-во элементов коллекции: " + orgs.size());
                System.out.println("Дата инициализации: " + initializationDate);
                break;
            case "show":
                System.out.println(orgs.toString());
                break;
            case "add":
                AddOrganization.add(orgs);
                break;
            case "clear":
                orgs.clear();
                System.out.println("Коллекция очищена!");
                break;
            case "save":
                Scan.parseToXML(orgs,"C:\\Lab 5\\src\\Organizations.xml");
                break;
            case "exit":
                System.out.println("Конец программы!");
                System.exit(0);
                break;
            case "history":
                System.out.println(commands);
                break;
            default:
                if (scanner.findInLine("^update\\s+\\w+") != null) {
                    try {
                        scanner = new Scanner(command);
                        command = scanner.findInLine("\\s+\\w+\\s*");
                        scanner = new Scanner(command);
                        command = scanner.findInLine("\\w+");
                        long id = Long.parseLong(command);
                        long id1 = Long.parseLong(String.valueOf(SearchId.search(orgs, id)));
                        orgs.remove(id1);
                        AddOrganization.add(orgs);
                        System.out.println("ID обновлён!");
                    } catch (NumberFormatException e1) {
                        System.out.println("Неверный ID!");
                    }
                } else if(scanner.findInLine("^remove by id\\s+\\w+") != null){
                    try {
                        scanner = new Scanner(command);
                        command = scanner.findInLine("\\s+\\w+\\s*");
                        scanner = new Scanner(command);
                        command = scanner.findInLine("\\w+");
                        long id = Long.parseLong(command);
                        long id1 = Long.parseLong(String.valueOf(SearchId.search(orgs, id)));
                        orgs.remove(id1);
                        System.out.println("Элемент по ID удалён!");
                    }catch(NumberFormatException e1){
                        System.out.println("Неверный ID!");
                    }
                } else if (scanner.findInLine("^remove_all_by_annual_turnover\\s+\\S+") != null) {
                    try {
                        scanner = new Scanner(command);
                        command = scanner.findInLine("\\s\\S+");
                        scanner = new Scanner(command);
                        command = scanner.findInLine("\\S+");
                        int annualTurnover = Integer.parseInt(command);
                        SearchAT.search(orgs, annualTurnover);
                    }catch(NumberFormatException e1){
                        System.out.println("Неверный ID!");
                    }
                } else if (scanner.findInLine("^filter_greater_than_postal_address\\s+\\w+") != null) {
                    try {
                        scanner = new Scanner(command);
                        command = scanner.findInLine("\\s\\S+");
                        scanner = new Scanner(command);
                        command = scanner.findInLine("\\S+");
                        address.greater(orgs,command);
                    }catch(NumberFormatException e1){
                        System.out.println("Невозможный Postal Address!");
                    }
                } else if (scanner.findInLine("^filter_less_than_postal_address\\s+\\w+") != null) {
                    try {
                        scanner = new Scanner(command);
                        command = scanner.findInLine("\\s\\S+");
                        scanner = new Scanner(command);
                        command = scanner.findInLine("\\S+");
                        address.less(orgs,command);
                    }catch(NumberFormatException e1){
                        System.out.println("Невозможный Postal Address!");
                    }
                } else if (scanner.findInLine("^execute_script\\s+\\S+") != null) {
                    try {
                        scanner = new Scanner(command);
                        command = scanner.findInLine("\\s\\S+");
                        scanner = new Scanner(command);
                        command = scanner.findInLine("\\S+");
                        ExecuteScript.newCom(orgs,commands,previousFilenames, command, initializationDate);
                    }catch(NumberFormatException e1){
                        System.out.println("Неверный ввод!");
                    }
                } else if (scanner.findInLine("^remove_greater\\s+\\S+") != null) {
                    try {
                        scanner = new Scanner(command);
                        command = scanner.findInLine("\\s\\S+");
                        scanner = new Scanner(command);
                        command = scanner.findInLine("\\S+");
                        RemoveGreater.remGr(orgs, Long.parseLong(command));
                    }catch(NumberFormatException e1){
                        System.out.println("Неверный ввод!");
                    }
                } else if (scanner.findInLine("^add_if_min\\s+\\S+") != null) {
                    try {
                        scanner = new Scanner(command);
                        command = scanner.findInLine("\\s\\S+");
                        scanner = new Scanner(command);
                        command = scanner.findInLine("\\S+");
                        AddIfMin.addIfMin(orgs, Long.parseLong(command));
                    }catch(NumberFormatException e1){
                        System.out.println("Неверный ввод!");
                    }
                }
        }
        return orgs;
    }
}