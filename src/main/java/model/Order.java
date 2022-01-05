package model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Order {

    Map<Long, OrderItem> orderItemMap = new HashMap<>();

    public void putOrder(long orderNumber, OrderItem orderItem) {
        orderItemMap.put(orderNumber, orderItem);
    }

}
