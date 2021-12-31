package model;

import lombok.Data;


@Data
public class OrderItem {
    private int orderQuantity;
    private String orderFormatCode;

    public OrderItem(int orderQuantity, String orderFormatCode) {
        this.orderQuantity = orderQuantity;
        this.orderFormatCode = orderFormatCode;
    }
}
