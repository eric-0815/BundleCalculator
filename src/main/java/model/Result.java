package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Result {
    List<ResultItem> resultItemList = new ArrayList<>();

    public void addResult(ResultItem eachBundleResult) {
        resultItemList.add(eachBundleResult);
    }
}
