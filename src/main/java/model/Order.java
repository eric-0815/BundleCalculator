package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Order {
    List<OrderItem> orderItems = new ArrayList<>();

    public void addOrder(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    private List<OrderItem> sameFormatCodeHelper(String formatCode) {
        List<OrderItem> sameFormatCodeArrayList;
        sameFormatCodeArrayList = orderItems.stream().filter(x -> x.getOrderFormatCode().equals(formatCode)).collect(Collectors.toList());
        return sameFormatCodeArrayList;
    }

    public List<OrderItem> getImgOrderList() {
        List<OrderItem> imgArrayList;
        imgArrayList = sameFormatCodeHelper("IMG");
        return imgArrayList;
    }

    public List<OrderItem> getFlacOrderList() {
        List<OrderItem> flacOrderList;
        flacOrderList = sameFormatCodeHelper("FLAC");
        return flacOrderList;
    }

    public List<OrderItem> getVidOrderList() {
        List<OrderItem> vidOrderList;
        vidOrderList = sameFormatCodeHelper("VID");
        return vidOrderList;
    }
}
