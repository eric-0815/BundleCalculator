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
        Order order = inputReader.readInputFile(inputFile);
        OrderItem[] allOrderListTest = new OrderItem[]{new OrderItem(10, "IMG"), new OrderItem(15, "FLAC"), new OrderItem(13, "VID")};
        // Test AllOrder
        assertEquals(order.getAllOrderArrayList(), Arrays.asList(allOrderListTest));

        Bundle allBundles = inputReader.readPriceFile(priceFile);
        BundleItem[] allBundleListTest = new BundleItem[]{new BundleItem("IMG", 5, 450.0), new BundleItem("IMG", 10, 800.0), new BundleItem("Flac", 3, 427.5), new BundleItem("Flac", 6, 810.0), new BundleItem("Flac", 9, 1147.5), new BundleItem("VID", 3, 570.0), new BundleItem("VID", 5, 900.0), new BundleItem("VID", 9, 1530.0)};
        // Test AllBundle
        assertEquals(allBundles.getAllBundleArrayList(), Arrays.asList(allBundleListTest));

        Calculation calculation = new Calculation();
        Result result = new Result();
        calculation.priceCalculator(result, order.getIMGOrderList(), allBundles.getIMGBundleList());
        calculation.priceCalculator(result, order.getFlacOrderList(), allBundles.getFlacBundleList());
        calculation.priceCalculator(result, order.getVIDOrderList(), allBundles.getVIDBundleList());

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

        ResultItem[] allBundleResultsTest = new ResultItem[]{new ResultItem("IMG", 10, 800.0, imgPriceListTest, imgCalculationMap), new ResultItem("FLAC", 15, 1957.5, flacPriceListTest, flacCalculationMap), new ResultItem("VID", 13, 2370.0, vidPriceListTest, vidCalculationMap)};

        // Test AllBundleResult
        for (int i = 0; i < result.getAllBundleResultArrayList().size(); i++) {
            assertEquals(result.getAllBundleResultArrayList().get(i).getResultFormatCode(), Arrays.asList(allBundleResultsTest).get(i).getResultFormatCode());
            assertEquals(result.getAllBundleResultArrayList().get(i).getResultQuantity(), Arrays.asList(allBundleResultsTest).get(i).getResultQuantity());
            assertEquals(result.getAllBundleResultArrayList().get(i).getResultPrice(), Arrays.asList(allBundleResultsTest).get(i).getResultPrice());
            assertEquals(result.getAllBundleResultArrayList().get(i).getPriceList(), Arrays.asList(allBundleResultsTest).get(i).getPriceList());
            assertEquals(result.getAllBundleResultArrayList().get(i).getCalculationProcessMap(), Arrays.asList(allBundleResultsTest).get(i).getCalculationProcessMap());
        }

    }
}
