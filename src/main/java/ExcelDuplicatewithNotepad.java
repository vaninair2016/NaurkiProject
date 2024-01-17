import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelDuplicatewithNotepad {
    public static void main(String[] args) throws Exception {
        File f = new File(System.getProperty("user.dir") + "\\csvfiles\\Subject Data Review - IP Data Report.xlsx");
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet0 = wb.getSheetAt(0);

        Map<String, List<Integer>> rowMap = new HashMap<>();
        int totalDuplicates = 0;

        for (Row row : sheet0) {
            StringBuilder rowData = new StringBuilder();
            for (Cell cell : row) {
                rowData.append(cell.toString()).append("|"); // append cell data and a separator
            }
            String rowString = rowData.toString();
            if (!rowMap.containsKey(rowString)) {
                rowMap.put(rowString, new ArrayList<Integer>());
            }
            rowMap.get(rowString).add(row.getRowNum() + 1); // add row number to the list
        }

        try (FileWriter writer = new FileWriter("duplicates.txt")) {
            for (Map.Entry<String, List<Integer>> entry : rowMap.entrySet()) {
                if (entry.getValue().size() > 1) { // if the list size is more than 1, it means the row is duplicated
                    writer.write("Duplicate rows found at: " + entry.getValue() + "\n");
                    totalDuplicates += entry.getValue().size() - 1; // count duplicates
                }
            }
            writer.write("Total number of duplicate rows: " + totalDuplicates + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (totalDuplicates == 0) {
            System.out.println("No duplicate rows found.");
        } else {
            System.out.println("Total number of duplicate rows: " + totalDuplicates);
            System.out.println("Details have been written to duplicates.txt");
        }
    }
}
