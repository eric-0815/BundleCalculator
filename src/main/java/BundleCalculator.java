import lombok.extern.java.Log;
import model.*;

import java.io.IOException;


@Log
public class BundleCalculator {
    public static void main(String[] args) throws IOException {
        String inputFile = "inputFile.TXT";
        String priceFile = "priceFile.TXT";
        String outputFile = "outFile.TXT";
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
