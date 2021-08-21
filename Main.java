import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        try {
            Date initializationDate = new Date();
            boolean exit = false;
            String buffer = args[0];
            LinkedHashSet organizations = Scan.parseFromXML(buffer);
            ArrayList<String> commands = new ArrayList<>();
            String filename = buffer;
            Path filenamePath = Paths.get(filename);
            if (filenamePath.toRealPath().toString().length() > 3 && filenamePath.toRealPath().toString().trim().startsWith("/dev"))
                throw new InvalidPathException("", "Строка не может быть преобразована в путь!");
            while (!exit) {
                System.out.print("Введите команду. (Чтобы вывести список команд, введите \"help\"): ");
                try {
                    buffer = in.nextLine();
                } catch (NoSuchElementException e) {
                    System.out.println("Нажато Ctrl+D, программа не завершена!");
                    System.exit(0);
                }
                Scanner scanner = new Scanner(buffer);
                String bufferIfer = scanner.findInLine("^\\S+");
                if (bufferIfer.equals("help") | bufferIfer.equals("info") | bufferIfer.equals("show") | bufferIfer.equals("add") | bufferIfer.equals("update") | bufferIfer.equals("remove_by_id") | bufferIfer.equals("clear") | bufferIfer.equals("save") | bufferIfer.equals("execute_script") | bufferIfer.equals("exit") | bufferIfer.equals("add_if_min") | bufferIfer.equals("remove_greater") | bufferIfer.equals("history") | bufferIfer.equals("remove_all_by_annual_turnover") | bufferIfer.equals("filter_less_than_postal_address") | bufferIfer.equals("filter_greater_than_postal_address")) {
                    commands.add(bufferIfer);
                    if (commands.size() > 15) {
                        commands.remove(0);
                    }
                    DetermineCommand.command(buffer, organizations, commands, new ArrayList(), filename, initializationDate);
                } else {
                    System.out.println("Неверная команда!");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Нажато Ctrl+D, программа завершена!");
            System.exit(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Вы не передали адрес файла *.xml!");
            System.exit(0);
        } catch (InvalidPathException e){
            System.out.println("Имя файла неверно!");
        }
    }
}