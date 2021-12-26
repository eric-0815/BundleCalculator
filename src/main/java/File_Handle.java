import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class File_Handle {
    public HashMap<String, Integer> read_file(String file_name) throws IOException {
        HashMap<String, Integer> item_map = new HashMap<String, Integer>();
        File file = new File(file_name);
        try {// create a new file if the file does not exist
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("A new file is created!!!");
            }
            String line;
            BufferedReader file_reader = new BufferedReader(new FileReader(file));
            while ((line = file_reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    int quantity = Integer.parseInt(parts[0]);
                    String item_name = parts[1];
                    item_map.put(item_name, quantity);
                    System.out.println(quantity+" "+item_name);
                } else {
                    System.out.println("Please check your input format");
                }
            }
            file_reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item_map;
    }
}
