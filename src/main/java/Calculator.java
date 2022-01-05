import model.BundleItem;
import model.ResultItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.*;


public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public ResultItem calculateBundle(int orderQuantity, List<BundleItem> bundleArrayList) {
        ResultItem resultItem;
        int calculatedQuantity;
        Map<Integer, Integer> calculationProcessMap = new HashMap<>();
        List<BigDecimal> priceList = new ArrayList<>();
        try {
            for (int i = 0; i < bundleArrayList.size(); i++) {
                int bundleQuantity = bundleArrayList.get(i).getBundleQuantity();
                Double bundlePrice = bundleArrayList.get(i).getBundlePrice();
                for (int j = 0; j < bundleArrayList.size(); j++) {
                    int nextBundleQuantity = bundleArrayList.get(j).getBundleQuantity();
                    Double nextBundlePrice = bundleArrayList.get(j).getBundlePrice();
                    for (int k = 0; k < bundleArrayList.size() * bundleArrayList.size(); k++) {
                        calculatedQuantity = bundleQuantity * (i + 1) + nextBundleQuantity * (k);
                        if (calculatedQuantity == orderQuantity) {
                            calculationProcessMap.put(bundleQuantity, (i + 1));
                            priceList.add(BigDecimal.valueOf(bundlePrice * (i + 1)));
                            if (k != 0) {
                                calculationProcessMap.put(nextBundleQuantity, (k));
                                priceList.add(BigDecimal.valueOf(nextBundlePrice));
                            }
                            Map<Integer, Integer> reverseCalculationProcessMap = new LinkedHashMap<>();
                            calculationProcessMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEachOrdered(x -> reverseCalculationProcessMap.put(x.getKey(), x.getValue()));
                            resultItem = new ResultItem(bundleArrayList.get(i).getBundleFormatCode(), priceList, reverseCalculationProcessMap);
                            return resultItem;
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

}
