package pdf.extractor.demo;

import com.aspose.pdf.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws IOException {
        var test = new ClassPathResource("RAPORT_2018_04.pdf");
        Document document = new Document(test.getInputStream());
        TableAbsorber absorber = new TableAbsorber();
        absorber.visit(document.getPages().get_Item(4));
        for (Page page : document.getPages()) {
            // Invoke the visit method to extract table from the page
            absorber.visit(page);
            // Call the getTableList method that returns readonly IList containing tables that were found
            for (AbsorbedTable table : absorber.getTableList()) {
                System.out.println("Table");
                // Get the rows by calling the getRowList method Iterate through list of rows
                for (AbsorbedRow row : table.getRowList()) {
                    // Iterate through list of cell by invoking the getCellList method
                    for (AbsorbedCell cell : row.getCellList()) {
                        // Invoke the getTextFragments method to get collection of TextFragment objects that describes text containing in the cell
                        for (TextFragment fragment : cell.getTextFragments()) {
                            StringBuilder sb = new StringBuilder();
                            // Invoke the getSegments method that gets text segments for current TextFragment.
                            for (TextSegment seg : fragment.getSegments())
                                sb.append(seg.getText());
                            System.out.print(sb + "|");
                        }
                    }
                    System.out.println();
                }
            }
        }

//        PdfDocument pdf = new PdfDocument(test.getInputStream());
//        PdfTableExtractor extractor = new PdfTableExtractor(pdf);
//        PdfTable[] pdfTables  = extractor.extractTable(4);
//
//        Workbook wb = new Workbook();
//        wb.getWorksheets().clear();
//        Worksheet sheet = wb.getWorksheets().add("Tabela strona 4");
//        //Loop through the rows in the current table
//        for (int rowNum = 0; rowNum < pdfTables[0].getRowCount(); rowNum++) {
//            //Loop through the columns in the current table
//            for (int colNum = 0; colNum < pdfTables[0].getColumnCount(); colNum++) {
//                //Extract data from the current table cell
//                String text = pdfTables[0].getText(rowNum, colNum);
//
//                //Insert data into a specific cell
//                sheet.get(rowNum + 1, colNum + 1).setText(text);
//            }
//        }
//        //Auto fit column width
//        for (int sheetColNum = 0; sheetColNum < sheet.getColumns().length; sheetColNum++) {
//            sheet.autoFitColumn(sheetColNum + 1);
//        }
//        //Save the workbook to an Excel file
//        wb.saveToFile("exportTableToExcel.xlsx", ExcelVersion.Version2016);


//        PdfReader reader = new PdfReader(test.getInputStream());
//        int pages = reader.getNumberOfPages();
//        var page4 = PdfTextExtractor.getTextFromPage(reader, 4);
//        var page5 = PdfTextExtractor.getTextFromPage(reader, 5);
//        reader.close();
        SpringApplication.run(DemoApplication.class, args);
    }

}
