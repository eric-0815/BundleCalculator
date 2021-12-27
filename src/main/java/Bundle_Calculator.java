import lombok.*;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.*;



@Log
public class Bundle_Calculator {
    //static Logger logger = Logger.getLogger(String.valueOf(Bundle_Calculator.class));
    private static Double Bundle_Calculator(@NonNull String target_item, int target_quantity, HashMap<Integer,Double> quantity_price_map) {
        Stream_Handler stream_handler = new Stream_Handler();
        List<Integer> quantity_list;
        List<Double> price_list;

        quantity_list = stream_handler.get_key_stream(quantity_price_map).collect(Collectors.toList());
        Collections.sort(quantity_list, Collections.reverseOrder());
        System.out.println(quantity_list);
        //price_list = stream_handler.get_value_stream(quantity_price_map).collect(Collectors.toList());
        Double final_price;
        HashMap<Integer, Integer> result_map = new HashMap<Integer, Integer>();
        List<Integer> result_list = quantity_list.stream()
                .filter(x -> x == target_quantity)
                .collect(Collectors.toList());
        if(!result_list.isEmpty()){
            result_map.put(result_list.get(0), 1);
            final_price = quantity_price_map.get(result_list.get(0));
            log_function(target_item, target_quantity,quantity_price_map, result_map, final_price);
        }else{
            Boolean got_target_quantity = false;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++) {
                    for(int k=1; k < 9; k++){
                        int calculated_quantity = quantity_list.get(i)*(i+1)+quantity_list.get(j)*(k);
                        if(calculated_quantity == target_quantity && !got_target_quantity){
                            System.out.println(quantity_list.get(i).toString()+" * "+(i+1)+" + "+quantity_list.get(j).toString()+" * " +(k));
                            System.out.println("target_quantity is : "+target_quantity);
                            final_price = (quantity_price_map.get(quantity_list.get(i))*(i+1)+quantity_price_map.get(quantity_list.get(j))*(k));
                            result_map.put(quantity_list.get(i),i+1);
                            result_map.put(quantity_list.get(j),k);
                            //System.out.println(quantity_list.get(i)+" "+ (i+1));
                            //System.out.println(quantity_list.get(j)+" "+ k);
                            got_target_quantity = true;
                            log_function(target_item, target_quantity,quantity_price_map, result_map, final_price);
                            break;
                        }
                    }
                }
            }
        }
        return 0.0;
    }

    private static void log_function(String target_item, int target_quantity, HashMap<Integer, Double> quantity_price_map, HashMap<Integer, Integer> result_map, Double final_price){
        String padding = null;
        for (Map.Entry<Integer, Integer> entry : result_map.entrySet()) {
            if(padding == null) {
                padding = entry.getKey().toString() + " x " + entry.getValue().toString() + " $" + quantity_price_map.get(entry.getKey());
            }else{
                padding = padding +"\n"+"        "+entry.getKey().toString() + " x " + entry.getValue().toString() + " $" + quantity_price_map.get(entry.getKey());
            }
        }
        log.info(target_quantity+" "+target_item+" "+final_price+'\n'+"        "+padding);
    }

    public static void main(String[] args) throws IOException{
        //logger.info("INFO MSG");
        /*
        IntStream
                .range(1,10)
                .skip(5)
                .forEach(x -> System.out.println(x));
        System.out.println();*/

        String input_file = "bundle.TXT";
        String price_file = "price_info.TXT";
        File_Handle file_handle = new File_Handle();
        HashMap<String,Integer> input_map = file_handle.read_input_file(input_file);

        HashMap<Integer,Double> image_map = new HashMap<>();
        HashMap<Integer,Double> audio_map = new HashMap<>();
        HashMap<Integer,Double> video_map = new HashMap<>();
        file_handle.read_price_file(price_file, "IMG", image_map);
        file_handle.read_price_file(price_file, "Flac", audio_map);
        file_handle.read_price_file(price_file, "VID", video_map);
/*
        for (Map.Entry<Integer, Double> entry : video_map.entrySet()) {
            System.out.println(entry.getKey()+","+entry.getValue());
        }*/
        //System.out.println(audio_map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList()));
        Stream_Handler stream_handler = new Stream_Handler();
        // entriesStream
        Stream<Map.Entry<String, Integer>> input_stream = stream_handler.get_entries_stream(input_map);
        List<Map.Entry<String, Integer>> input_list = input_stream.collect(Collectors.toList());

        String target_item;
        int target_quantity;
        Double final_price = 0.0;


        for(int i=0; i<input_list.size(); i++){
            target_item = input_list.get(i).getKey();
            target_quantity = input_list.get(i).getValue();
            if(target_item.equals("IMG")){
                Bundle_Calculator(target_item, target_quantity, image_map);
            }else if(target_item.equals("FLAC")){
                Bundle_Calculator(target_item, target_quantity, audio_map);
            }else{
                Bundle_Calculator(target_item, target_quantity, video_map);
            }
        }
    }
}
