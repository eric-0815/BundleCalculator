import model.Bundle;
import model.Order;
import model.Result;

import java.io.IOException;


public class BundleCalculator {
    public static void main(String[] args) throws IOException {
        String inputFile = "inputFile.TXT";
        String priceFile = "priceFile.TXT";
        String outputFile = "outputFile.TXT";
        // Use FileHandler to open files
        OrderReader orderReader = new OrderReader();
        Order orders = orderReader.readInputFile(inputFile);
        Bundle bundles = orderReader.readPriceFile(priceFile);

        OrderProcess orderProcess = new OrderProcess();
        Result results = orderProcess.process(orders, bundles);

        OrderWriter orderWriter = new OrderWriter();
        orderWriter.writeFile(results, outputFile);
    }
}
