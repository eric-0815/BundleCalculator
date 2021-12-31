import lombok.Data;
import model.Bundle;
import model.BundleItem;
import model.Order;
import model.OrderItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class InputReader {
    private static final Logger logger = LogManager.getLogger(Calculation.class);
    public Order readInputFile(String fileName) throws IOException {
        Order order = new Order();
        BufferedReader fileReader = readFile(fileName);
        String line;
        while ((line = fileReader.readLine()) != null) {
            String[] parts = line.split(" ");
            if (parts.length == 2) {
                order.addOrder(new OrderItem(Integer.parseInt(parts[0]), parts[1]));
            } else {
                throw new IOException("Please check your input format");
            }
        }
        fileReader.close();
        return order;
    }

    public Bundle readPriceFile(String fileName) throws IOException {
        Bundle allBundles = new Bundle();
        BufferedReader fileReader = readFile(fileName);
        String line;
        while ((line = fileReader.readLine()) != null) {
            String formatCode = line.split(" ")[2];
            int startIndex = 4;
            int endIndex = line.split(" ").length;
            String[] sliced_line = Arrays.copyOfRange(line.split(" "), startIndex, endIndex);
            List<String> line_without_symbol = Arrays.stream(sliced_line).filter(x -> !x.equals("@")).collect(Collectors.toList());
            for (int i = 0; i < line_without_symbol.size(); i = i + 2) {
                allBundles.addBundle(new BundleItem(formatCode, Integer.parseInt(line_without_symbol.get(i)), Double.parseDouble(line_without_symbol.get(i + 1).replace("$", ""))));
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
                logger.info("A new file is created!!!");
            }
            fileReader = new BufferedReader(new java.io.FileReader(file));
        } catch (IOException ex) {
            throw new IOException("There is a problem with the file");
        }
        return fileReader;
    }
}
