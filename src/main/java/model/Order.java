package model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Order {

    Map<Integer, String> orderItemMap = new HashMap<>();

    public void putOrder(OrderItem orderItem) {
        orderItemMap.put(orderItem.getOrderQuantity(), orderItem.getOrderFormatCode());
    }

}
