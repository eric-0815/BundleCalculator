import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

@Log
class Calculation_HandlerTest {
    Calculation_Handler calculation_handler = new Calculation_Handler();
    HashMap<Integer, Double> test_map  = new HashMap<Integer, Double>() {{
        put(5, 450.0);
        put(10, 800.0);
    }};
    @BeforeEach
    void setUp() {
        log.info("@@Calculation_HandlerTest.setUp #17: setUp");
    }

    @AfterEach
    void tearDown() {
        log.info("@@Calculation_HandlerTest.tearDown #22: tearDown");
    }

    @Test
    void calculation() {
        calculation_handler.calculation("IMG", 10, test_map);
    }
}