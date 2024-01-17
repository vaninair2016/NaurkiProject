
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CompareCSV {
    public static void main(String[] args) throws IOException {
    	File file1 = new File(System.getProperty("user.dir") + "\\csvfiles\\Subject Data Review - Physical Examination Report.csv");
        File file2 = new File(System.getProperty("user.dir") + "\\csvfiles\\PE_DB.csv");
        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);

        Workbook workbook1 = WorkbookFactory.create(fis1);
        Workbook workbook2 = WorkbookFactory.create(fis2);

        Sheet sheet1 = workbook1.getSheetAt(0);
        Sheet sheet2 = workbook2.getSheetAt(0);

        for (int i = 0; i <= sheet1.getLastRowNum(); i++) {
            Row row1 = sheet1.getRow(i);
            Row row2 = sheet2.getRow(i);

            if (row2 == null) {
                row2 = sheet2.createRow(i);
            }

            for (int j = 0; j < row1.getLastCellNum(); j++) {
                Cell cell1 = row1.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                Cell cell2 = row2.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                String cellValue1 = getCellValue(cell1);
                String cellValue2 = getCellValue(cell2);

                if (!cellValue1.equals(cellValue2)) {
                    System.out.println("Difference found at row: " + (i + 1) + ", column: " + (j + 1));
                }
            }
        }

        fis1.close();
        fis2.close();
    }

    private static String getCellValue(Cell cell) {
        String cellValue;
        if (cell.getCellType() == CellType.STRING) {
            cellValue = cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            cellValue = Double.toString(cell.getNumericCellValue());
        } else {
            cellValue = "";
        }

        if (cellValue.endsWith(".0")) {
            cellValue = cellValue.substring(0, cellValue.length() - 2); // remove trailing ".0"
        }

        if (cellValue.contains("T")) {
            cellValue = cellValue.substring(0, cellValue.indexOf("T")); // remove time part
        }

        return cellValue;
    }
}

