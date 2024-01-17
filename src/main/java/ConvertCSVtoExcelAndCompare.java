
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ConvertCSVtoExcelAndCompare {
    public static void main(String[] args) throws Exception {
        String csvFileAddress = System.getProperty("user.dir") + "\\csvfiles\\SDR_ECG_Snowflake.csv"; //csv file address
        String xlsxFileAddress = System.getProperty("user.dir") + "\\csvfiles\\SDR_ECG_Snowflake.xlsx"; //xlsx file address

        // Convert CSV to XLSX
        Workbook workBook = new XSSFWorkbook();
        Sheet sheet = workBook.createSheet("sheet1");
        String currentLine;
        int RowNum=0;
        BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
        while ((currentLine = br.readLine()) != null) {
            String str[] = currentLine.split(",");
            RowNum++;
            Row currentRow=sheet.createRow(RowNum);
            for(int i=0;i<str.length;i++){
                currentRow.createCell(i).setCellValue(str[i]);
            }
        }
        FileOutputStream fileOutputStream =  new FileOutputStream(xlsxFileAddress);
        workBook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("CSV file was converted to Excel and saved at " + xlsxFileAddress);

        // Now compare the two Excel files
        File file1 = new File(xlsxFileAddress);
        File file2 = new File(System.getProperty("user.dir") + "\\csvfiles\\Subject Data Review-ECG.xlsx");

        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);

        Workbook wb1 = WorkbookFactory.create(fis1);
        Workbook wb2 = WorkbookFactory.create(fis2);

        Sheet sheet1 = wb1.getSheetAt(0);
        Sheet sheet2 = wb2.getSheetAt(0);

        Map<String, List<Integer>> rowMap1 = getRowMap(sheet1);
        Map<String, List<Integer>> rowMap2 = getRowMap(sheet2);

        compareRowMaps(rowMap1, rowMap2);
    }

    private static Map<String, List<Integer>> getRowMap(Sheet sheet) {
        Map<String, List<Integer>> rowMap = new HashMap<>();
        for (Row row : sheet) {
            StringBuilder rowData = new StringBuilder();
            for (Cell cell : row) {
                rowData.append(cell.toString()).append("|");
            }
            String rowString = rowData.toString();
            if (!rowMap.containsKey(rowString)) {
            	rowMap.put(rowString, new ArrayList<Integer>());
            }
            rowMap.get(rowString).add(row.getRowNum() + 1);
        }
        return rowMap;
    }

    private static void compareRowMaps(Map<String, List<Integer>> rowMap1, Map<String, List<Integer>> rowMap2) {
        boolean hasMismatch = false;
        for (Map.Entry<String, List<Integer>> entry : rowMap1.entrySet()) {
            if (!rowMap2.containsKey(entry.getKey())) {
                System.out.println("Row found in first sheet but not in second: " + entry.getValue());
                hasMismatch = true;
            }
        }
        for (Map.Entry<String, List<Integer>> entry : rowMap2.entrySet()) {
            if (!rowMap1.containsKey(entry.getKey())) {
                System.out.println("Row found in second sheet but not in first: " + entry.getValue());
                hasMismatch = true;
            }
        }
        if (!hasMismatch) {
            System.out.println("No mismatch found between the two sheets.");
        }
    }
}
