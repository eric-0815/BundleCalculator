import lombok.ToString;
import model.AllBundleResult;
import model.EachBundleResult;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


public class OutputWriter {
    public void writeFile(AllBundleResult allBundleResult, String fileName) {
        File file = new File(fileName);
        ArrayList<EachBundleResult> allBundleResultArrayList = allBundleResult.getAllBundleResultArrayList();
        BufferedWriter bufferedWriter = null;
        String resultText = null;
        try { // iterate the HashMap and write into the file
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < allBundleResultArrayList.size(); i++) {
                EachBundleResult eachBundleResult = allBundleResultArrayList.get(i);
                resultText = eachBundleResult.getResultQuantity() + " " + eachBundleResult.getResultFormatCode() + " $" + eachBundleResult.getResultPrice();
                int index = 0;
                for (Map.Entry entry : allBundleResult.getAllBundleResultArrayList().get(i).getCalculationProcessMap().entrySet()) {
                    resultText = resultText + "\n  " + entry.getValue() + " x " + entry.getKey() + " " + eachBundleResult.getPriceList().get(index++);
                }
                resultText = resultText + "\n";
                bufferedWriter.write(resultText);
            }
            bufferedWriter.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
