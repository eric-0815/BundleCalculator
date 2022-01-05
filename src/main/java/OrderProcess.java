import model.Bundle;
import model.Order;
import model.Result;

public class OrderProcess {
    public Result process(Order orders, Bundle bundles) {
        Result results = new Result();
        Calculator calculator = new Calculator();
        orders.getOrderItemMap().entrySet().stream().filter(x -> x.getValue().equals("IMG")).forEach(item -> results.addResult(calculator.calculateBundle(item.getKey(), bundles.getImgBundleList())));
        orders.getOrderItemMap().entrySet().stream().filter(x -> x.getValue().equals("FLAC")).forEach(item -> results.addResult(calculator.calculateBundle(item.getKey(), bundles.getFlacBundleList())));
        orders.getOrderItemMap().entrySet().stream().filter(x -> x.getValue().equals("VID")).forEach(item -> results.addResult(calculator.calculateBundle(item.getKey(), bundles.getVidBundleList())));
        return results;
    }
}
