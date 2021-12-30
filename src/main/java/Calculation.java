import model.AllBundles;
import model.EachBundle;
import model.EachOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Calculation {
    public String priceCalculator(ArrayList<EachOrder> allOrdersArrayList, ArrayList<EachBundle> bundleArrayList) {
        int calculatedQuantity = 0;
        for (int i = 0; i < allOrdersArrayList.size(); i++) {
            int orderQuantity = allOrdersArrayList.get(i).getOrderQuantity();
            String orderFormatCode = allOrdersArrayList.get(i).getOrderFormatCode();
            String bundleFormatCode = bundleArrayList.get(i).getBundleFormatCode();
            int bundleQuantity = bundleArrayList.get(i).getBundleQuantity();
            Double bundlePrice = bundleArrayList.get(i).getBundlePrice();
            for (int j = 0; j < bundleArrayList.size(); j++){
                String nextBundleFormatCode = bundleArrayList.get(j).getBundleFormatCode();
                int nextBundleQuantity = bundleArrayList.get(j).getBundleQuantity();
                Double nextBundlePrice = bundleArrayList.get(j).getBundlePrice();
                    for(int k=0; k < bundleArrayList.size()*bundleArrayList.size(); k++){
                        calculatedQuantity = bundleQuantity*(i+1)+nextBundleQuantity*(k);
                        //System.out.println(bundleArrayList+ " = bundleQuantity * "+(i+1) + " nextBundleQuantity * "+(k) );
                        if(calculatedQuantity == 10 || calculatedQuantity == 13 ||calculatedQuantity == 15 ){
                            System.out.println(calculatedQuantity);
                        }
                    }
                }
            }


        return null;
    }

}
