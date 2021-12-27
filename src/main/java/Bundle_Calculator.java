import lombok.extern.java.Log;

import java.io.IOException;
import java.util.*;
import java.util.stream.*;



@Log
public class Bundle_Calculator {
    public static void main(String[] args) throws IOException{
        String input_file = "bundle.TXT";
        String price_file = "price_info.TXT";
        // Use File_Handler to open files
        File_Handler file_handler = new File_Handler();
        HashMap<String,Integer> input_map = file_handler.read_input_file(input_file);
        // load price information into maps
        HashMap<Integer,Double> image_map = new HashMap<>();
        HashMap<Integer,Double> audio_map = new HashMap<>();
        HashMap<Integer,Double> video_map = new HashMap<>();
        file_handler.read_price_file(price_file, "IMG", image_map);
        file_handler.read_price_file(price_file, "Flac", audio_map);
        file_handler.read_price_file(price_file, "VID", video_map);

        // Use Stream_Handler to the stream of entrySet()
        Stream_Handler stream_handler = new Stream_Handler();
        Stream<Map.Entry<String, Integer>> input_stream = stream_handler.get_entries_stream(input_map);
        List<Map.Entry<String, Integer>> input_list = input_stream.collect(Collectors.toList());

        String target_item;
        int target_quantity;
        // Use Calculation_Handler to calculate results
        Calculation_Handler calculation_handler = new Calculation_Handler();
        for(int i=0; i<input_list.size(); i++){
            target_item = input_list.get(i).getKey();
            target_quantity = input_list.get(i).getValue();
            if(target_item.equals("IMG")){
                calculation_handler.calculation(target_item, target_quantity, image_map);
            }else if(target_item.equals("FLAC")){
                calculation_handler.calculation(target_item, target_quantity, audio_map);
            }else{
                calculation_handler.calculation(target_item, target_quantity, video_map);
            }
        }
    }
}
