import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;


@Log
class File_HandleTest {
    File_Handler file_handler = new File_Handler();
    @BeforeEach
    void setUp() {
        log.info("@@File_HandleTest.setUp #14: setUp");
    }

    @AfterEach
    void tearDown() {
        log.info("@@File_HandleTest.tearDown #19: tearDown");
    }

    @Test
    void read_input_file() throws IOException {
        file_handler.read_input_file("bundle.TXT");
    }

    @Test
    void read_price_file() throws IOException {
        HashMap<Integer,Double> test_map = new HashMap<>();
        file_handler.read_price_file("price_info.TXT", "IMG", test_map);
        file_handler.read_price_file("price_info.TXT", "Flac", test_map);
        file_handler.read_price_file("price_info.TXT", "VID", test_map);
    }
}