package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

@Getter
public class Bundle {
    ArrayList<BundleItem> allBundleArrayList = new ArrayList<BundleItem>();

    public void addBundle(BundleItem eachBundle) {
        allBundleArrayList.add(eachBundle);
    }

    private ArrayList<BundleItem> sameFormatCodeHelper(String formatCode) {
        ArrayList<BundleItem> sameFormatCodeArrayList;
        sameFormatCodeArrayList = (ArrayList<BundleItem>) allBundleArrayList.stream().filter(x -> x.getBundleFormatCode().equals(formatCode)).collect(Collectors.toList());
        sameFormatCodeArrayList.sort(Comparator.comparing(BundleItem::getBundleQuantity));
        Collections.reverse(sameFormatCodeArrayList);
        return sameFormatCodeArrayList;
    }


    public ArrayList<BundleItem> getIMGBundleList() {
        ArrayList<BundleItem> IMGBundleList;
        IMGBundleList = sameFormatCodeHelper("IMG");
        return IMGBundleList;
    }

    public ArrayList<BundleItem> getFlacBundleList() {
        ArrayList<BundleItem> FlacBundleList;
        FlacBundleList = sameFormatCodeHelper("Flac");
        return FlacBundleList;
    }

    public ArrayList<BundleItem> getVIDBundleList() {
        ArrayList<BundleItem> VIDBundleList;
        VIDBundleList = sameFormatCodeHelper("VID");
        return VIDBundleList;
    }


}
