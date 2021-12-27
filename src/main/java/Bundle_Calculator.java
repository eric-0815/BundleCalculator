import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.*;
public class Bundle_Calculator {
    static Logger logger = Logger.getLogger(String.valueOf(Bundle_Calculator.class));
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
        HashMap<String,Integer> item_map = file_handle.read_input_file(input_file);

        HashMap<String,Double> image_map = new HashMap<>();
        HashMap<String,Double> audio_map = new HashMap<>();
        HashMap<String,Double> video_map = new HashMap<>();
        file_handle.read_price_file(price_file, "IMG", image_map);
        file_handle.read_price_file(price_file, "Flac", audio_map);
        file_handle.read_price_file(price_file, "VID", video_map);

        //System.out.println(audio_map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList()));
        Stream_Handler stream_handler = new Stream_Handler();
        // entriesStream
        Stream<Map.Entry<String, Integer>> entries_stream = stream_handler.get_entries_stream(item_map);
        //System.out.println("entriesStream: "+ entries_stream.collect(Collectors.toList()).get(0).getValue());
    }
}
