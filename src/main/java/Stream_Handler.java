import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Stream_Handler {
    public Stream<Map.Entry<String, Integer>> get_entries_stream(HashMap item_map){
        Set<Map.Entry<String, Integer>> entries = item_map.entrySet();
        Stream<Map.Entry<String, Integer>> entries_stream = entries.stream();
        return entries_stream;
    }

    public Stream<Integer> get_key_stream(HashMap item_map){
        Set<Integer> item_set = item_map.keySet();
        Stream<Integer> item_stream = item_set.stream();
        return item_stream;
    }
}
