package model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class EachBundle {
    private String bundleFormatCode;
    private int bundleQuantity;
    private Double bundlePrice;

    public EachBundle(String bundleFormatCode, int bundleQuantity, Double bundlePrice) {
        this.bundleFormatCode = bundleFormatCode;
        this.bundleQuantity = bundleQuantity;
        this.bundlePrice = bundlePrice;
    }
}
