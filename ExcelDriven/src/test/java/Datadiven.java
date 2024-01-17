import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.util.NumberToTextConverter;

public class Datadiven {

    public ArrayList<String> getData(String testCaseName) {
        ArrayList<String> testData = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("C:\\Users\\91789\\Documents\\demdata.xlsx");
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = findSheetByName(workbook, "testdata");
            int columnIndex = findColumnIndex(sheet, "TestCases");

            Iterator<Row> rows = sheet.iterator();
            rows.next(); // Skip the header row

            while (rows.hasNext()) {
                Row row = rows.next();

                if (isTestCaseRow(row, columnIndex, testCaseName)) {
                    extractDataFromRow(row, testData);
                    break; // No need to continue after finding the relevant row
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return testData;
    }

    private XSSFSheet findSheetByName(XSSFWorkbook workbook, String sheetName) {
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            XSSFSheet sheet = workbook.getSheetAt(i);
            if (sheet.getSheetName().equalsIgnoreCase(sheetName)) {
                return sheet;
            }
        }
        throw new IllegalArgumentException("Sheet not found: " + sheetName);
    }

    private int findColumnIndex(XSSFSheet sheet, String columnName) {
        Row firstRow = sheet.getRow(0);
        Iterator<Cell> cellIterator = firstRow.cellIterator();
        int columnIndex = 0;

        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
                return columnIndex;
            }
            columnIndex++;
        }

        throw new IllegalArgumentException("Column not found: " + columnName);
    }

    private boolean isTestCaseRow(Row row, int columnIndex, String testCaseName) {
        return row.getCell(columnIndex).getStringCellValue().equalsIgnoreCase(testCaseName);
    }

    private void extractDataFromRow(Row row, ArrayList<String> testData) {
        Iterator<Cell> cellIterator = row.cellIterator();

        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();

            if (cell.getCellType() == CellType.STRING) {
                testData.add(cell.getStringCellValue());
            } else {
                testData.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
            }
        }
    }

    public static void main(String[] args) {
        Datadiven dataDriven = new Datadiven();
        ArrayList<String> testData = dataDriven.getData("Purchase");

        for (String data : testData) {
            System.out.println(data);
        }
    }
}
