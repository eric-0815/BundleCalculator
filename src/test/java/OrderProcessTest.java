import model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderProcessTest {
    @Test
    void CalculatorTest() {
        Order orders = new Order();
        orders.addOrder(new OrderItem(10, "IMG"));
        orders.addOrder(new OrderItem(15, "FLAC"));
        orders.addOrder(new OrderItem(13, "VID"));

        Bundle bundles = new Bundle();
        bundles.addBundle(new BundleItem("IMG", 10, 800.0));
        bundles.addBundle(new BundleItem("IMG", 5, 450.0));
        bundles.addBundle(new BundleItem("Flac", 9, 1147.5));
        bundles.addBundle(new BundleItem("Flac", 6, 810.0));
        bundles.addBundle(new BundleItem("Flac", 3, 427.5));
        bundles.addBundle(new BundleItem("VID", 9, 1530.0));
        bundles.addBundle(new BundleItem("VID", 5, 900.0));
        bundles.addBundle(new BundleItem("VID", 3, 570.0));

        Result expectedResult = new Result();
        Calculator calculator = new Calculator();
        orders.getImgOrderList().forEach(item -> expectedResult.addResult(calculator.calculateBundle(item.getOrderQuantity(), bundles.getImgBundleList())));
        orders.getFlacOrderList().forEach(item -> expectedResult.addResult(calculator.calculateBundle(item.getOrderQuantity(), bundles.getFlacBundleList())));
        orders.getVidOrderList().forEach(item -> expectedResult.addResult(calculator.calculateBundle(item.getOrderQuantity(), bundles.getVidBundleList())));

        Result actualResult = new Result();
        List imgPriceList = new ArrayList(Collections.singletonList(BigDecimal.valueOf(800.0)));
        Map<Integer, Integer> imgMap = new HashMap<Integer, Integer>() {{
            put(10, 1);
        }};

        List flacPriceList = new ArrayList(Arrays.asList(BigDecimal.valueOf(1147.5), BigDecimal.valueOf(810.0)));
        Map<Integer, Integer> flacMap = new HashMap<Integer, Integer>() {{
            put(9, 1);
            put(6, 1);
        }};

        List vidPriceList = new ArrayList(Arrays.asList(BigDecimal.valueOf(1800.0), BigDecimal.valueOf(570.0)));
        Map<Integer, Integer> vidMap = new HashMap<Integer, Integer>() {{
            put(5, 2);
            put(3, 1);
        }};

        actualResult.addResult(new ResultItem("IMG", imgPriceList, imgMap));
        actualResult.addResult(new ResultItem("Flac", flacPriceList, flacMap));
        actualResult.addResult(new ResultItem("VID", vidPriceList, vidMap));

        for (int i = 0; i < expectedResult.getResultItemList().size(); i++) {
            assertEquals(expectedResult.getResultItemList().get(i).getResultFormatCode(), actualResult.getResultItemList().get(i).getResultFormatCode());
            assertEquals(expectedResult.getResultItemList().get(i).getPriceList(), actualResult.getResultItemList().get(i).getPriceList());
            assertEquals(expectedResult.getResultItemList().get(i).getCalculationProcessMap(), actualResult.getResultItemList().get(i).getCalculationProcessMap());
        }
    }
}
