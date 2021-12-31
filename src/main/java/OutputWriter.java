import model.Result;
import model.ResultItem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


public class OutputWriter {
    public void writeFile(Result result, String fileName) {
        File file = new File(fileName);
        ArrayList<ResultItem> allBundleResultArrayList = result.getAllBundleResultArrayList();
        BufferedWriter bufferedWriter = null;
        String resultText = null;
        try { // iterate the HashMap and write into the file
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < allBundleResultArrayList.size(); i++) {
                ResultItem eachBundleResult = allBundleResultArrayList.get(i);
                resultText = eachBundleResult.getResultQuantity() + " " + eachBundleResult.getResultFormatCode() + " $" + eachBundleResult.getResultPrice();
                int index = 0;
                for (Map.Entry entry : result.getAllBundleResultArrayList().get(i).getCalculationProcessMap().entrySet()) {
                    resultText = resultText + "\n  " + entry.getValue() + " x " + entry.getKey() + " $" + eachBundleResult.getPriceList().get(index++);
                }
                resultText = resultText + "\n";
                bufferedWriter.write(resultText);
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
