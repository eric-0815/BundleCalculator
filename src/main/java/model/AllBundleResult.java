package model;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class AllBundleResult {
    ArrayList<ResultItem> allBundleResultArrayList = new ArrayList<>();

    public void addBundleResult(ResultItem eachBundleResult) {
        allBundleResultArrayList.add(eachBundleResult);
    }
}
