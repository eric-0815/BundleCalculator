import model.Bundle;
import model.Order;
import model.Result;

public class OrderProcess {
    public Result process(Order orders, Bundle bundles) {
        Result results = new Result();
        Calculator calculator = new Calculator();
        orders.getOrderItemMap().entrySet().stream().filter(x -> x.getValue().getOrderFormatCode().equals("IMG")).forEach(item -> results.addResult(calculator.calculateBundle(item.getValue().getOrderQuantity(), bundles.getImgBundleList())));
        orders.getOrderItemMap().entrySet().stream().filter(x -> x.getValue().getOrderFormatCode().equals("FLAC")).forEach(item -> results.addResult(calculator.calculateBundle(item.getValue().getOrderQuantity(), bundles.getFlacBundleList())));
        orders.getOrderItemMap().entrySet().stream().filter(x -> x.getValue().getOrderFormatCode().equals("VID")).forEach(item -> results.addResult(calculator.calculateBundle(item.getValue().getOrderQuantity(), bundles.getVidBundleList())));
        return results;
    }
}
