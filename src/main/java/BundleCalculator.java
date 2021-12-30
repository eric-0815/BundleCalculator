import lombok.extern.java.Log;
import model.AllBundles;
import model.EachBundle;
import model.EachOrder;

import java.io.IOException;
import java.util.*;


@Log
public class BundleCalculator {
    public static void main(String[] args) throws IOException {
        String inputFile = "inputFile.TXT";
        String priceFile = "priceFile.TXT";


        // Use FileHandler to open files
        FileReader fileReader = new FileReader();
        ArrayList <EachOrder> allOrdersArrayList = fileReader.readInputFile(inputFile);
        AllBundles allBundles = fileReader.readPriceFile(priceFile);

        Calculation calculation = new Calculation();

        String imgResult = calculation.priceCalculator(allOrdersArrayList, allBundles.getIMGArrayList());
        String FlacResult = calculation.priceCalculator(allOrdersArrayList, allBundles.getFlacArrayList());
        String VIDResult = calculation.priceCalculator(allOrdersArrayList, allBundles.getVIDArrayList());

    }
}
