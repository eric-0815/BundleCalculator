package model;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Result {
    ArrayList<ResultItem> allBundleResultArrayList = new ArrayList<>();

    public void addResult(ResultItem eachBundleResult) {
        allBundleResultArrayList.add(eachBundleResult);
    }
}
