
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ExcelDuplicate {
	 public static void main(String[] args) throws Exception {
	        File f = new File(System.getProperty("user.dir") + "\\csvfiles\\Data Query AnalysisQuerydetails.xlsx");
	        FileInputStream fis = new FileInputStream(f);
	        Workbook wb = WorkbookFactory.create(fis);
	        Sheet sheet0 = wb.getSheetAt(0);

	        Map<String, List<Integer>> rowMap = new HashMap<>();
	        boolean hasDuplicates = false;

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

	        for (Map.Entry<String, List<Integer>> entry : rowMap.entrySet()) {
	            if (entry.getValue().size() > 1) { // if the list size is more than 1, it means the row is duplicated
	                System.out.println("Duplicate rows found at: " + entry.getValue());
	                hasDuplicates = true;
	            }
	        }

	        if (!hasDuplicates) {
	            System.out.println("No duplicate rows found.");
	        }
	    }
	}

