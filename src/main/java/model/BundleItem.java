package model;

import lombok.Data;


@Data
public class BundleItem {
    private String bundleFormatCode;
    private int bundleQuantity;
    private Double bundlePrice;

    public BundleItem(String bundleFormatCode, int bundleQuantity, Double bundlePrice) {
        this.bundleFormatCode = bundleFormatCode;
        this.bundleQuantity = bundleQuantity;
        this.bundlePrice = bundlePrice;
    }
}
