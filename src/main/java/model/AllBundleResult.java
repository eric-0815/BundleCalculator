package model;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class AllBundleResult {
    ArrayList<EachBundleResult> allBundleResultArrayList = new ArrayList<>();

    public void addBundleResult(EachBundleResult eachBundleResult) {
        allBundleResultArrayList.add(eachBundleResult);
    }
}
