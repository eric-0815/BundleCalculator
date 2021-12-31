import model.AllBundleResult;
import model.Bundle;
import model.Order;

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
        AllBundleResult allBundleResult = new AllBundleResult();
        calculation.priceCalculator(allBundleResult, order.getIMGOrderList(), allBundles.getIMGBundleList());
        calculation.priceCalculator(allBundleResult, order.getFlacOrderList(), allBundles.getFlacBundleList());
        calculation.priceCalculator(allBundleResult, order.getVIDOrderList(), allBundles.getVIDBundleList());

        OutputWriter fileWriter = new OutputWriter();
        fileWriter.writeFile(allBundleResult, outputFile);
    }
}
