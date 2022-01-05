package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Bundle {
    List<BundleItem> allBundleArrayList = new ArrayList<>();

    public void addBundle(BundleItem eachBundle) {
        allBundleArrayList.add(eachBundle);
    }

    private List<BundleItem> sameFormatCodeHelper(String formatCode) {
        List<BundleItem> sameFormatCodeArrayList;
        sameFormatCodeArrayList = allBundleArrayList.stream().filter(x -> x.getBundleFormatCode().equals(formatCode)).collect(Collectors.toList());
        sameFormatCodeArrayList.sort(Comparator.comparing(BundleItem::getBundleQuantity));
        Collections.reverse(sameFormatCodeArrayList);
        return sameFormatCodeArrayList;
    }


    public List<BundleItem> getImgBundleList() {
        List<BundleItem> imgBundleList;
        imgBundleList = sameFormatCodeHelper("IMG");
        return imgBundleList;
    }

    public List<BundleItem> getFlacBundleList() {
        List<BundleItem> flacBundleList;
        flacBundleList = sameFormatCodeHelper("Flac");
        return flacBundleList;
    }

    public List<BundleItem> getVidBundleList() {
        List<BundleItem> vidBundleList;
        vidBundleList = sameFormatCodeHelper("VID");
        return vidBundleList;
    }
}
