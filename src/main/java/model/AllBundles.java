package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

@Getter
public class AllBundles {
    ArrayList<EachBundle> allBundleArrayList = new ArrayList<EachBundle>();

    public void addBundle(EachBundle eachBundle) {
        allBundleArrayList.add(eachBundle);
    }

    private ArrayList<EachBundle> sameFormatCodeHelper(String formatCode) {
        ArrayList<EachBundle> sameFormatCodeArrayList;
        sameFormatCodeArrayList = (ArrayList<EachBundle>) allBundleArrayList.stream().
                filter(x -> x.getBundleFormatCode().equals(formatCode)).
                collect(Collectors.toList());
        sameFormatCodeArrayList.sort(Comparator.comparing(EachBundle::getBundleQuantity));
        Collections.reverse(sameFormatCodeArrayList);
        return sameFormatCodeArrayList;
    }


    public ArrayList<EachBundle> getIMGBundleList() {
        ArrayList<EachBundle> IMGBundleList;
        IMGBundleList = sameFormatCodeHelper("IMG");
        return IMGBundleList;
    }

    public ArrayList<EachBundle> getFlacBundleList() {
        ArrayList<EachBundle> FlacBundleList;
        FlacBundleList = sameFormatCodeHelper("Flac");
        return FlacBundleList;
    }

    public ArrayList<EachBundle> getVIDBundleList() {
        ArrayList<EachBundle> VIDBundleList;
        VIDBundleList = sameFormatCodeHelper("VID");
        return VIDBundleList;
    }


}
