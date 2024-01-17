import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.DataFormatter;

public class CompareTwoExcel {
    public static void main(String[] args) throws Exception {
        File file1 = new File(System.getProperty("user.dir") + "\\csvfiles\\PE_DB_01.xlsx");
        File file2 = new File(System.getProperty("user.dir") + "\\csvfiles\\Physical Examination Report.xlsx");

        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);

        Workbook wb1 = WorkbookFactory.create(fis1);
        Workbook wb2 = WorkbookFactory.create(fis2);

        Sheet sheet1 = wb1.getSheetAt(0);
        Sheet sheet2 = wb2.getSheetAt(0);

        FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + "\\csvfiles\\mismatch.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        Map<String, String> sheet1Data = getSheetData(sheet1);
        Map<String, String> sheet2Data = getSheetData(sheet2);

        boolean hasMismatch = compareSheetData(sheet1Data, sheet2Data, bufferedWriter);

        if (hasMismatch) {
            System.out.println("Mismatch found. Please check the mismatch.txt file for details.");
        } else {
            System.out.println("No mismatch found.");
        }

        bufferedWriter.close();
        fis1.close();
        fis2.close();
    }

    private static Map<String, String> getSheetData(Sheet sheet) {
        Map<String, String> sheetData = new HashMap<>();
        int uniqueSubjectIdentifierColumn = -1;
        int sequenceNumberColumn = -1;

        // Find the column indices
        Row headerRow = sheet.getRow(0);
        for (Cell headerCell : headerRow) {
            if (getCellValue(headerCell).equals("Unique Subject Identifier")) {
                uniqueSubjectIdentifierColumn = headerCell.getColumnIndex();
            } else if (getCellValue(headerCell).equals("Sequence Number")) {
                sequenceNumberColumn = headerCell.getColumnIndex();
            }
        }

        if (uniqueSubjectIdentifierColumn == -1 || sequenceNumberColumn == -1) {
            throw new IllegalArgumentException("Could not find the required columns");
        }

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Cell uniqueSubjectIdentifierCell = row.getCell(uniqueSubjectIdentifierColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            Cell sequenceNumberCell = row.getCell(sequenceNumberColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            String key = getCellValue(uniqueSubjectIdentifierCell) + "|" + getCellValue(sequenceNumberCell);
            String value = getRowData(row);
            sheetData.put(key, value);
        }
        return sheetData;
    }


    private static String getRowData(Row row) {
        StringBuilder rowData = new StringBuilder();
        for (Cell cell : row) {
            rowData.append(getCellValue(cell)).append("|");
        }
        return rowData.toString();
    }
    private static String getCellValue(Cell cell) {
        DataFormatter formatter = new DataFormatter();
        String cellValue = formatter.formatCellValue(cell);

        if (cellValue.endsWith(".0")) {
            cellValue = cellValue.substring(0, cellValue.length() - 2); // remove trailing ".0"
        }

        if (cellValue.contains("T")) {
            cellValue = cellValue.substring(0, cellValue.indexOf("T")); // remove time part
        }

        return cellValue;
    }


    private static boolean compareSheetData(Map<String, String> sheet1Data, Map<String, String> sheet2Data, BufferedWriter bufferedWriter) throws IOException {
        boolean hasMismatch = false;
        for (Map.Entry<String, String> entry : sheet1Data.entrySet()) {
            String key = entry.getKey();
            String value1 = entry.getValue();
            String value2 = sheet2Data.get(key);

            if (value2 == null) {
                bufferedWriter.write("Row with key " + key + " exists in first sheet but not in second");
                bufferedWriter.newLine();
                hasMismatch = true;
            } else if (!value1.equals(value2)) {
                bufferedWriter.write("Mismatch found for row with key " + key + ". Value in first file: " + value1 + ", Value in second file: " + value2);
                bufferedWriter.newLine();
                hasMismatch = true;
            }
        }

        for (String key : sheet2Data.keySet()) {
            if (!sheet1Data.containsKey(key)) {
                bufferedWriter.write("Row with key " + key + " exists in second sheet but not in first");
                bufferedWriter.newLine();
                hasMismatch = true;
            }
        }

        return hasMismatch;
    }
}
