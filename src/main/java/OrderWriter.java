import model.Result;
import model.ResultItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class OrderWriter {
    private static final Logger logger = LogManager.getLogger(OrderWriter.class);

    public void writeFile(Result result, String fileName) {
        File file = new File(fileName);
        List<ResultItem> results = result.getResultItemList();
        BufferedWriter bufferedWriter;
        String resultText;
        int resultQuantity;
        BigDecimal resultPrice;
        try { // iterate the HashMap and write into the file
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < results.size(); i++) {
                resultQuantity = results.get(i).calculateResultQuantity();
                resultPrice = results.get(i).calculateResultPrice();

                ResultItem resultItem = results.get(i);
                resultText = resultQuantity + " " + resultItem.getResultFormatCode().toUpperCase() + " $" + resultPrice;
                int index = 0;
                for (Map.Entry entry : result.getResultItemList().get(i).getCalculationProcessMap().entrySet()) {
                    resultText = resultText + "\n  " + entry.getValue() + " x " + entry.getKey() + " $" + resultItem.getPriceList().get(index++);
                }
                resultText = resultText + "\n";
                bufferedWriter.write(resultText);
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            logger.error(e);
        }
    }
}
