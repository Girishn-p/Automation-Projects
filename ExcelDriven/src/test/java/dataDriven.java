import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

    public ArrayList<String> getData(String testCaseName) {
        ArrayList<String> testData = new ArrayList<String>();

        try (FileInputStream fis = new FileInputStream("C:\\Users\\91789\\Documents\\demdata.xlsx");
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("testdata");

            // Identify Testcases column by scanning the entire 1st row
            Iterator<Row> rows = sheet.iterator();
            Row firstRow = rows.next();
            Iterator<Cell> cellIterator = firstRow.cellIterator();

            int columnIndex = 0;
            int k = 0;

            while (cellIterator.hasNext()) {
                Cell value = cellIterator.next();

                if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
                    columnIndex = k;
                }

                k++;
            }

            System.out.println("TestCases column index: " + columnIndex);

            // Once the column is identified, scan the entire TestCases column to find the specified test case
            while (rows.hasNext()) {
                Row row = rows.next();

                if (row.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("testCases")) {
                    // After identifying the test case row, pull all the data of that row and feed into the test data list
                    Iterator<Cell> cellIteratorForRow = row.cellIterator();

                    while (cellIteratorForRow.hasNext()) {
                        Cell cell = cellIteratorForRow.next();

                        if (cell.getCellType() == CellType.STRING) {
                            testData.add(cell.getStringCellValue());
                        } else {
                            testData.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testData;
    }

    public static void main(String[] args) throws IOException {
        // Example of how to use the getData method
        dataDriven dataDriven = new dataDriven();
        ArrayList<String> testData = dataDriven.getData("Purchase");

        // Process the testData as needed
        for (String data : testData) {
            System.out.println(data);
        }
    }
}
