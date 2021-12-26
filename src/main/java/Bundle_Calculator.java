import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
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
        File_Handle file_handle = new File_Handle();
        HashMap<String,Integer> item_map = file_handle.read_file("bundle.TXT");
    }
}
