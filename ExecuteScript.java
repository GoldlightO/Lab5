import java.io.*;
import java.util.*;

public class ExecuteScript {
    private static final ArrayList<String> s = new ArrayList<>();
    public static void newCom(LinkedHashSet <Organization> orgs, ArrayList<String> commands, ArrayList<String> previousFilenames, String filename) throws IOException {
        try {
            for (String object: previousFilenames) {
                if (filename.equals(object)) {
                    throw new RecursionException();
                }
            }
            System.out.println("Добавлено имя файла: " + filename);
            previousFilenames.add(filename);
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = "";
            while ((line = reader.readLine()) != null) {
                s.add(line);
                DetermineCommand.command(line, orgs, commands, previousFilenames, filename);
            }
        }catch(RecursionException recursionException) {
            System.out.println(recursionException.getMessage());
        }catch(IOException e){
            System.out.println("Неверное имя файла!");
        }catch(NoSuchElementException e){
            System.out.println("Нажато Ctrl+D, программа не завершена!");
            System.exit(0);
        }
    }
}