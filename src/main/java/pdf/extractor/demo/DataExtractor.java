package pdf.extractor.demo;

import java.util.ArrayList;
import java.util.List;

public class DataExtractor {
    private static final String PAGE_4_HEADER = "PLN/MWh EUR/MWh % PLN/MWh PLN/MWh MWh MWh\n";


    private DataExtractor() {
    }

    public static List<DataRecord> convertPageToList(String page) {
        String tableData = page.substring(page.lastIndexOf(PAGE_4_HEADER), page.indexOf("Page  4  from"));
        List<DataRecord> records = new ArrayList<>();
        String[] rows = tableData.split("\n");
        for (var row : rows) {
            String test = "BASE_W-15-18 193,53 46,14 -0,75 187,50 197,50 39 816 38 976 237 64";
            String[] values = row.split(" ");
            records.add(new DataRecord(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9]));
        }

        return List.of();
    }
}
