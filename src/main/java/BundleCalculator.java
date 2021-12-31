import model.AllBundleResult;
import model.AllBundles;
import model.AllOrders;

import java.io.IOException;


public class BundleCalculator {
    public static void main(String[] args) throws IOException {
        String inputFile = "inputFile.TXT";
        String priceFile = "priceFile.TXT";
        String outputFile = "outputFile.TXT";
        // Use FileHandler to open files
        InputReader inputReader = new InputReader();
        AllOrders allOrders = inputReader.readInputFile(inputFile);
        AllBundles allBundles = inputReader.readPriceFile(priceFile);

        Calculation calculation = new Calculation();
        AllBundleResult allBundleResult = new AllBundleResult();
        calculation.priceCalculator(allBundleResult, allOrders.getIMGOrderList(), allBundles.getIMGBundleList());
        calculation.priceCalculator(allBundleResult, allOrders.getFlacOrderList(), allBundles.getFlacBundleList());
        calculation.priceCalculator(allBundleResult, allOrders.getVIDOrderList(), allBundles.getVIDBundleList());

        OutputWriter fileWriter = new OutputWriter();
        fileWriter.writeFile(allBundleResult, outputFile);
    }
}
