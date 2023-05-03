package pdf.extractor.demo;

public record DataRecord(String product,
                         String wAvgPricePln,
                         String wAvgPriceEur,
                         String wAvgPriceChange,
                         String LowPrice,
                         String HighPrice,
                         String Volume,
                         String VolChange,
                         String TraderContr,
                         String NumberOfTrades) {
}
