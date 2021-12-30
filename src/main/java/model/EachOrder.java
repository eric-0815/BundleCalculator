package model;

import lombok.Data;


@Data
public class EachOrder {
    private int orderQuantity;
    private String orderFormatCode;

    public EachOrder(int orderQuantity, String orderFormatCode){
        this.orderQuantity = orderQuantity;
        this.orderFormatCode = orderFormatCode;
    }
}
