import lombok.NonNull;
import lombok.extern.java.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
@Log
public class File_Handler {
    public HashMap<String, Integer> read_input_file(String file_name) throws IOException {
        HashMap<String, Integer> item_map = new HashMap<String, Integer>();
        File file = new File(file_name);
        try {// create a new file if the file does not exist
            if (!file.exists()) {
                file.createNewFile();
                log.info("A new file is created!!!");
            }
            String line;
            BufferedReader file_reader = new BufferedReader(new FileReader(file));
            while ((line = file_reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    int quantity = Integer.parseInt(parts[0]);
                    String item_name = parts[1];
                    item_map.put(item_name, quantity);
                } else {
                    log.warning("Please check your input format");
                }
            }
            file_reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item_map;
    }

    public void read_price_file(@NonNull String file_name, String type, HashMap<Integer, Double> map) throws IOException {
        HashMap<String, Integer> item_map = new HashMap<String, Integer>();
        File file = new File(file_name);
        try {// create a new file if the file does not exist
            if (!file.exists()) {
                file.createNewFile();
                log.info("A new file is created!!!");
            }
            String line;
            BufferedReader file_reader = new BufferedReader(new FileReader(file));
            while ((line = file_reader.readLine()) != null) {
                int startIndex = 4;
                int endIndex = line.split(" ").length;
                String[] sliced_line = Arrays.copyOfRange(line.split(" "), startIndex, endIndex);
                if(line.split(" ")[2].equals(type)){
                    load_price(sliced_line, map);
                }
            }
            file_reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load_price (String[] line, HashMap<Integer, Double> map){
        List<String> line_without_symbol = Arrays.stream(line)
                .filter(x -> !x.equals("@"))
                .collect(Collectors.toList());
        for(int i=0; i<line_without_symbol.size(); i=i+2){
            map.put(Integer.valueOf(line_without_symbol.get(i)), Double.valueOf(line_without_symbol.get(i+1).replace("$","")));
        }
    }
}
