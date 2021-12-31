package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Getter
public class AllOrders {
    ArrayList<EachOrder> allOrderArrayList = new ArrayList<EachOrder>();

    public void addOrder(EachOrder eachOrder) {
        allOrderArrayList.add(eachOrder);
    }

    private ArrayList<EachOrder> sameFormatCodeHelper(String formatCode) {
        ArrayList<EachOrder> sameFormatCodeArrayList = new ArrayList<EachOrder>();
        sameFormatCodeArrayList = (ArrayList<EachOrder>) allOrderArrayList.stream().filter(x -> x.getOrderFormatCode().equals(formatCode)).collect(Collectors.toList());
        return sameFormatCodeArrayList;
    }

    public ArrayList<EachOrder> getIMGOrderList() {
        ArrayList<EachOrder> IMGArrayList = new ArrayList<>();
        IMGArrayList = sameFormatCodeHelper("IMG");
        return IMGArrayList;
    }

    public ArrayList<EachOrder> getFlacOrderList() {
        ArrayList<EachOrder> FlacOrderList = new ArrayList<>();
        FlacOrderList = sameFormatCodeHelper("FLAC");
        return FlacOrderList;
    }

    public ArrayList<EachOrder> getVIDOrderList() {
        ArrayList<EachOrder> VIDOrderList = new ArrayList<>();
        VIDOrderList = sameFormatCodeHelper("VID");
        return VIDOrderList;
    }
}
