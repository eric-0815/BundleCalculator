import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BundleCalculatorTest {
    @Test
    public void BundleCalculatorTest() throws IOException {
        String inputFile = "inputFile.TXT";
        String priceFile = "priceFile.TXT";
        // Use FileHandler to open files
        InputReader inputReader = new InputReader();
        AllOrders allOrders = inputReader.readInputFile(inputFile);
        EachOrder[] allOrderListTest = new EachOrder[]{new EachOrder(10, "IMG"), new EachOrder(15, "FLAC"), new EachOrder(13, "VID")};
        // Test AllOrder
        assertEquals(allOrders.getAllOrderArrayList(), Arrays.asList(allOrderListTest));

        AllBundles allBundles = inputReader.readPriceFile(priceFile);
        EachBundle[] allBundleListTest = new EachBundle[]{new EachBundle("IMG", 5, 450.0), new EachBundle("IMG", 10, 800.0), new EachBundle("Flac", 3, 427.5), new EachBundle("Flac", 6, 810.0), new EachBundle("Flac", 9, 1147.5), new EachBundle("VID", 3, 570.0), new EachBundle("VID", 5, 900.0), new EachBundle("VID", 9, 1530.0)};
        // Test AllBundle
        assertEquals(allBundles.getAllBundleArrayList(), Arrays.asList(allBundleListTest));

        Calculation calculation = new Calculation();
        AllBundleResult allBundleResult = new AllBundleResult();
        calculation.priceCalculator(allBundleResult, allOrders.getIMGOrderList(), allBundles.getIMGBundleList());
        calculation.priceCalculator(allBundleResult, allOrders.getFlacOrderList(), allBundles.getFlacBundleList());
        calculation.priceCalculator(allBundleResult, allOrders.getVIDOrderList(), allBundles.getVIDBundleList());

        ArrayList<Double> imgPriceListTest = new ArrayList<>();
        imgPriceListTest.add(800.0);
        HashMap<Integer, Integer> imgCalculationMap = new HashMap<>();
        imgCalculationMap.put(10, 1);


        ArrayList<Double> flacPriceListTest = new ArrayList<>();
        flacPriceListTest.add(1147.5);
        flacPriceListTest.add(810.0);
        HashMap<Integer, Integer> flacCalculationMap = new HashMap<>();
        flacCalculationMap.put(6, 1);
        flacCalculationMap.put(9, 1);
        ArrayList<Double> vidPriceListTest = new ArrayList<>();
        vidPriceListTest.add(1800.0);
        vidPriceListTest.add(570.0);
        HashMap<Integer, Integer> vidCalculationMap = new HashMap<>();
        vidCalculationMap.put(3, 1);
        vidCalculationMap.put(5, 2);

        EachBundleResult[] allBundleResultsTest = new EachBundleResult[]{new EachBundleResult("IMG", 10, 800.0, imgPriceListTest, imgCalculationMap), new EachBundleResult("FLAC", 15, 1957.5, flacPriceListTest, flacCalculationMap), new EachBundleResult("VID", 13, 2370.0, vidPriceListTest, vidCalculationMap)};

        // Test AllBundleResult
        for (int i = 0; i < allBundleResult.getAllBundleResultArrayList().size(); i++) {
            assertEquals(allBundleResult.getAllBundleResultArrayList().get(i).getResultFormatCode(), Arrays.asList(allBundleResultsTest).get(i).getResultFormatCode());
            assertEquals(allBundleResult.getAllBundleResultArrayList().get(i).getResultQuantity(), Arrays.asList(allBundleResultsTest).get(i).getResultQuantity());
            assertEquals(allBundleResult.getAllBundleResultArrayList().get(i).getResultPrice(), Arrays.asList(allBundleResultsTest).get(i).getResultPrice());
            assertEquals(allBundleResult.getAllBundleResultArrayList().get(i).getPriceList(), Arrays.asList(allBundleResultsTest).get(i).getPriceList());
            assertEquals(allBundleResult.getAllBundleResultArrayList().get(i).getCalculationProcessMap(), Arrays.asList(allBundleResultsTest).get(i).getCalculationProcessMap());
        }

    }
}
