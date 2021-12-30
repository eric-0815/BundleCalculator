package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

@Getter
public class AllBundles {
    ArrayList<EachBundle> allBundleArrayList = new ArrayList<EachBundle>();
    public void addBundle(EachBundle eachBundle){
        allBundleArrayList.add(eachBundle);
    }

    public void reverseOrderArrayList(){
        allBundleArrayList.sort(Comparator.comparing(EachBundle::getBundleQuantity));
        Collections.reverse(allBundleArrayList);
    }

    private ArrayList<EachBundle> sameFormatCodeHelper(String formatCode){
        ArrayList<EachBundle> sameFormatCodeArrayList = new ArrayList<EachBundle>();
        sameFormatCodeArrayList = (ArrayList<EachBundle>) allBundleArrayList.stream().
                filter(x -> x.getBundleFormatCode().equals(formatCode)).
                collect(Collectors.toList());
        sameFormatCodeArrayList.sort(Comparator.comparing(EachBundle::getBundleQuantity));
        Collections.reverse(sameFormatCodeArrayList);
        return sameFormatCodeArrayList;
    }


    public ArrayList<EachBundle> getIMGArrayList(){
        ArrayList<EachBundle> IMGArrayList = new ArrayList<EachBundle>();
        IMGArrayList = sameFormatCodeHelper("IMG");
        return IMGArrayList;
    }

    public ArrayList<EachBundle> getFlacArrayList(){
        ArrayList<EachBundle> FlacArrayList = new ArrayList<EachBundle>();
        FlacArrayList = sameFormatCodeHelper("Flac");
        return FlacArrayList;
    }

    public ArrayList<EachBundle> getVIDArrayList(){
        ArrayList<EachBundle> VIDArrayList = new ArrayList<EachBundle>();
        VIDArrayList = sameFormatCodeHelper("VID");
        return VIDArrayList;
    }



}
