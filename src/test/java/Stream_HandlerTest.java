import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

@Log
class Stream_HandlerTest {
    Stream_Handler stream_handler = new Stream_Handler();
    HashMap<String, Integer> test_map  = new HashMap<String, Integer>() {{
        put("VID", 13);
        put("IMG", 10);
        put("FLAC", 15);
    }};
    @BeforeEach
    void setUp() {
        log.info("@@Stream_HandlerTest.setUp #17: setUp");
    }

    @AfterEach
    void tearDown() {
        log.info("@@Stream_HandlerTest.tearDown #22: tearDown");
    }

    @Test
    void get_entries_stream() {
        stream_handler.get_entries_stream(test_map);
    }


    @Test
    void get_key_stream() {
        stream_handler.get_key_stream(test_map);
    }
}