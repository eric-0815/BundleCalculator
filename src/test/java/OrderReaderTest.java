import model.Bundle;
import model.BundleItem;
import model.Order;
import model.OrderItem;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderReaderTest {
    OrderReader orderReader = new OrderReader();

    @Test
    void testOrderReader() throws IOException {
        String inputFile = "inputFile.TXT";
        Order expectedOrder = orderReader.readInputFile(inputFile);

        Order actualOrder = new Order();
        actualOrder.addOrder(new OrderItem(10, "IMG"));
        actualOrder.addOrder(new OrderItem(15, "FLAC"));
        actualOrder.addOrder(new OrderItem(13, "VID"));
        assertEquals(expectedOrder.getOrderItems(), actualOrder.getOrderItems());

        String priceFile = "priceFile.TXT";
        Bundle expectedBundle = orderReader.readPriceFile(priceFile);
        Bundle actualBundle = new Bundle();
        actualBundle.addBundle(new BundleItem("IMG", 10, 800.0));
        actualBundle.addBundle(new BundleItem("IMG", 5, 450.0));
        actualBundle.addBundle(new BundleItem("Flac", 9, 1147.5));
        actualBundle.addBundle(new BundleItem("Flac", 6, 810.0));
        actualBundle.addBundle(new BundleItem("Flac", 3, 427.5));
        actualBundle.addBundle(new BundleItem("VID", 9, 1530.0));
        actualBundle.addBundle(new BundleItem("VID", 5, 900.0));
        actualBundle.addBundle(new BundleItem("VID", 3, 570.0));
        assertEquals(expectedBundle.getImgBundleList(), actualBundle.getImgBundleList());
        assertEquals(expectedBundle.getFlacBundleList(), actualBundle.getFlacBundleList());
        assertEquals(expectedBundle.getVidBundleList(), actualBundle.getVidBundleList());
    }
}
