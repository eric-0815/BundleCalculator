import lombok.NonNull;
import lombok.extern.java.Log;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Log
public class Calculation_Handler {
    public Double calculation(@NonNull String target_item, int target_quantity, HashMap<Integer,Double> quantity_price_map) {
        Stream_Handler stream_handler = new Stream_Handler();
        List<Integer> quantity_list;

        quantity_list = stream_handler.get_key_stream(quantity_price_map).collect(Collectors.toList());
        Collections.sort(quantity_list, Collections.reverseOrder());
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
                            final_price = (quantity_price_map.get(quantity_list.get(i))*(i+1)+quantity_price_map.get(quantity_list.get(j))*(k));
                            result_map.put(quantity_list.get(i),i+1);
                            result_map.put(quantity_list.get(j),k);
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

    private void log_function(String target_item, int target_quantity, HashMap<Integer, Double> quantity_price_map, HashMap<Integer, Integer> result_map, Double final_price){
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
}
