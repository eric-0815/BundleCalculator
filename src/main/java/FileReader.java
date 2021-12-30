import lombok.Data;
import lombok.extern.java.Log;
import model.AllBundles;
import model.EachBundle;
import model.EachOrder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Log
@Data
public class FileReader {
    public ArrayList <EachOrder> readInputFile(String fileName) throws IOException {
        //AllOrders allOrders = new AllOrders();
        ArrayList <EachOrder> allOrders = new ArrayList<EachOrder>();
        BufferedReader fileReader = readFile(fileName);
        String line;
        while ((line = fileReader.readLine()) != null) {
            String[] parts = line.split(" ");
            if (parts.length == 2) {
                allOrders.add(new EachOrder(Integer.parseInt(parts[0]), parts[1]));
            } else {
                log.warning("Please check your input format");
                throw new IOException("Please check your input format");
            }
        }
        fileReader.close();
        return allOrders;
    }

    public AllBundles readPriceFile(String fileName) throws IOException {
        //ArrayList <EachBundle> allBundles = new ArrayList<EachBundle>();
        AllBundles allBundles = new AllBundles();
        BufferedReader fileReader = readFile(fileName);
        String line;
        //AllBundles allBundles = new AllBundles();
        while ((line = fileReader.readLine()) != null) {

            String formatCode = line.split(" ")[2];

            int startIndex = 4;
            int endIndex = line.split(" ").length;
            String[] sliced_line = Arrays.copyOfRange(line.split(" "), startIndex, endIndex);
            List<String> line_without_symbol = Arrays.stream(sliced_line)
                    .filter(x -> !x.equals("@"))
                    .collect(Collectors.toList());
            for(int i=0; i<line_without_symbol.size(); i=i+2){
                //EachBundle eachBundle = new EachBundle();
                //eachBundle.setQuantity(Integer.parseInt(line_without_symbol.get(i)));
                //eachBundle.setPrice(Double.parseDouble(line_without_symbol.get(i+1).replace("$","")));
                //eachBundle.setFormatCode(formatCode);
                allBundles.addBundle(new EachBundle(formatCode,
                        Integer.parseInt(line_without_symbol.get(i)),
                        Double.parseDouble(line_without_symbol.get(i+1).replace("$",""))));
            }

        }
        return allBundles;
    }

    private BufferedReader readFile(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader fileReader = null;
        try {// create a new file if the file does not exist
            if (!file.exists()) {
                file.createNewFile();
                log.info("A new file is created!!!");
            }
            fileReader = new BufferedReader(new java.io.FileReader(file));
        } catch (IOException ex) {
            throw new IOException("There is a problem with the file");
        }
        return fileReader;
    }

}
