package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class EachBundleResult {
    private String resultFormatCode;
    private int resultQuantity;
    private Double resultPrice;
    private HashMap<Integer, Integer> calculationProcessMap;
    private ArrayList<Double> priceList;

    public EachBundleResult(String resultFormatCode, int resultQuantity, Double resultPrice, ArrayList<Double> priceList, HashMap<Integer, Integer> calculationProcessMap) {
        this.resultFormatCode = resultFormatCode;
        this.resultQuantity = resultQuantity;
        this.resultPrice = resultPrice;
        this.priceList = priceList;
        this.calculationProcessMap = calculationProcessMap;
    }
}
