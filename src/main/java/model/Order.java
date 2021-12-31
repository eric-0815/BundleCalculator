package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Getter
public class Order {
    ArrayList<OrderItem> allOrderArrayList = new ArrayList<OrderItem>();

    public void addOrder(OrderItem orderItem) {
        allOrderArrayList.add(orderItem);
    }

    private ArrayList<OrderItem> sameFormatCodeHelper(String formatCode) {
        ArrayList<OrderItem> sameFormatCodeArrayList = new ArrayList<OrderItem>();
        sameFormatCodeArrayList = (ArrayList<OrderItem>) allOrderArrayList.stream().filter(x -> x.getOrderFormatCode().equals(formatCode)).collect(Collectors.toList());
        return sameFormatCodeArrayList;
    }

    public ArrayList<OrderItem> getIMGOrderList() {
        ArrayList<OrderItem> IMGArrayList = new ArrayList<>();
        IMGArrayList = sameFormatCodeHelper("IMG");
        return IMGArrayList;
    }

    public ArrayList<OrderItem> getFlacOrderList() {
        ArrayList<OrderItem> FlacOrderList = new ArrayList<>();
        FlacOrderList = sameFormatCodeHelper("FLAC");
        return FlacOrderList;
    }

    public ArrayList<OrderItem> getVIDOrderList() {
        ArrayList<OrderItem> VIDOrderList = new ArrayList<>();
        VIDOrderList = sameFormatCodeHelper("VID");
        return VIDOrderList;
    }
}
