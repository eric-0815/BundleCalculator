import model.BundleItem;
import model.ResultItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    void testCalculator() {
        Calculator calculator = new Calculator();

        List<BundleItem> imgBundles = new ArrayList<>(Arrays.asList(new BundleItem("IMG", 10, 800.0), new BundleItem("IMG", 5, 450.0)));
        ResultItem imgResult = calculator.calculateBundle(10, imgBundles);
        assertEquals("IMG", imgResult.getResultFormatCode());
        assertEquals(10, imgResult.calculateResultQuantity());
        assertEquals(BigDecimal.valueOf(800.0), imgResult.calculateResultPrice());

        List<BundleItem> flacBundles = new ArrayList<>(Arrays.asList(new BundleItem("Flac", 9, 1147.5), new BundleItem("Flac", 6, 810.0), new BundleItem("Flac", 3, 427.5)));
        ResultItem flacResult = calculator.calculateBundle(15, flacBundles);
        assertEquals("Flac", flacResult.getResultFormatCode());
        assertEquals(15, flacResult.calculateResultQuantity());
        assertEquals(BigDecimal.valueOf(1957.5), flacResult.calculateResultPrice());

        List<BundleItem> vidBundles = new ArrayList<>(Arrays.asList(new BundleItem("VID", 9, 1530.0), new BundleItem("VID", 5, 900.0), new BundleItem("VID", 3, 570.0)));
        ResultItem vidResult = calculator.calculateBundle(13, vidBundles);
        assertEquals("VID", vidResult.getResultFormatCode());
        assertEquals(13, vidResult.calculateResultQuantity());
        assertEquals(BigDecimal.valueOf(2370.0), vidResult.calculateResultPrice());
    }
}
