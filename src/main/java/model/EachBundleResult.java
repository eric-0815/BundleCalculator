package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class EachBundleResult {
    private final String resultFormatCode;
    private final int resultQuantity;
    private final Double resultPrice;
    private final HashMap<Integer, Integer> calculationProcessMap;
    private final ArrayList<Double> priceList;

    public EachBundleResult(String resultFormatCode, int resultQuantity, Double resultPrice, ArrayList<Double> priceList, HashMap<Integer, Integer> calculationProcessMap) {
        this.resultFormatCode = resultFormatCode;
        this.resultQuantity = resultQuantity;
        this.resultPrice = resultPrice;
        this.priceList = priceList;
        this.calculationProcessMap = calculationProcessMap;
    }
}
