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
        InputReader inputReader = new InputReader();
        Order order = inputReader.readInputFile(inputFile);
        Bundle allBundles = inputReader.readPriceFile(priceFile);

        Calculation calculation = new Calculation();
        Result result = new Result();
        calculation.priceCalculator(result, order.getIMGOrderList(), allBundles.getIMGBundleList());
        calculation.priceCalculator(result, order.getFlacOrderList(), allBundles.getFlacBundleList());
        calculation.priceCalculator(result, order.getVIDOrderList(), allBundles.getVIDBundleList());

        OutputWriter fileWriter = new OutputWriter();
        fileWriter.writeFile(result, outputFile);
    }
}
