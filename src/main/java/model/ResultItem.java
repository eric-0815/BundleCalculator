package model;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Getter
public class ResultItem {
    private final String resultFormatCode;
    private final Map<Integer, Integer> calculationProcessMap;
    private final List<BigDecimal> priceList;

    public ResultItem(String resultFormatCode, List<BigDecimal> priceList, Map<Integer, Integer> calculationProcessMap) {
        this.resultFormatCode = resultFormatCode;
        this.priceList = priceList;
        this.calculationProcessMap = calculationProcessMap;
    }

    public int calculateResultQuantity() {
        return calculationProcessMap.entrySet().stream().map(x -> x.getKey() * x.getValue()).reduce(0, (a, b) -> a + b);
    }

    public BigDecimal calculateResultPrice() {
        return new BigDecimal(String.valueOf(priceList.stream().reduce(BigDecimal.valueOf(0), (a, b) -> a.add(b))));
    }
}
