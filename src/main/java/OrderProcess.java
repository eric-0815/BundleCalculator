import model.Bundle;
import model.Order;
import model.Result;

public class OrderProcess {
    public Result process(Order orders, Bundle bundles) {
        Result results = new Result();
        Calculator calculator = new Calculator();
        orders.getImgOrderList().forEach(item -> results.addResult(calculator.calculateBundle(item.getOrderQuantity(), bundles.getImgBundleList())));
        orders.getFlacOrderList().forEach(item -> results.addResult(calculator.calculateBundle(item.getOrderQuantity(), bundles.getFlacBundleList())));
        orders.getVidOrderList().forEach(item -> results.addResult(calculator.calculateBundle(item.getOrderQuantity(), bundles.getVidBundleList())));
        return results;
    }
}
