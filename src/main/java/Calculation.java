import model.AllBundleResult;
import model.EachBundleResult;
import model.EachBundle;
import model.EachOrder;

import java.util.*;

public class Calculation {
    public void priceCalculator(AllBundleResult allBundleResult, ArrayList<EachOrder> orderArrayList, ArrayList<EachBundle> bundleArrayList) {
        EachBundleResult eachBundleResult = null;
        boolean gotResult = false;
        int calculatedQuantity = 0;
        Double finalPrice = 0.0;
        HashMap<Integer, Integer> calculationProcessMap = new HashMap<>();
        ArrayList<Double> priceList = new ArrayList<>();
        int orderQuantity = orderArrayList.get(0).getOrderQuantity();
        String orderFormatCode = orderArrayList.get(0).getOrderFormatCode();
        for (int i = 0; i < bundleArrayList.size(); i++) {
            int bundleQuantity = bundleArrayList.get(i).getBundleQuantity();
            Double bundlePrice = bundleArrayList.get(i).getBundlePrice();
            for (int j = 0; j < bundleArrayList.size(); j++) {
                int nextBundleQuantity = bundleArrayList.get(j).getBundleQuantity();
                Double nextBundlePrice = bundleArrayList.get(j).getBundlePrice();
                for (int k = 0; k < bundleArrayList.size() * bundleArrayList.size(); k++) {
                    calculatedQuantity = bundleQuantity * (i + 1) + nextBundleQuantity * (k);
                    if (calculatedQuantity == orderQuantity && !gotResult) {
                        finalPrice = (bundlePrice * (i + 1) + nextBundlePrice * (k));
                        calculationProcessMap.put(bundleQuantity, (i + 1));
                        priceList.add(bundlePrice);
                        if (k != 0) {
                            calculationProcessMap.put(nextBundleQuantity, (k));
                            priceList.add(nextBundlePrice);
                        }
                        eachBundleResult = new EachBundleResult(orderFormatCode, orderQuantity, finalPrice, priceList, calculationProcessMap);
                        allBundleResult.addBundleResult(eachBundleResult);
                        gotResult = true;
                    }
                }
            }
        }
    }

}
