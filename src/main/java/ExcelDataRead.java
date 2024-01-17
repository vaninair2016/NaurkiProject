import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;


public class ExcelDataRead {

	public static void main(String[] args) throws IOException {
		FileInputStream excelFile = new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\main\\java\\testdata.xlsx"));
		Workbook workbook = new XSSFWorkbook(excelFile);
		Sheet datatypeSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = datatypeSheet.iterator();
		while(iterator.hasNext()) {
			Row currentRow= iterator.next();
			Iterator<Cell> cellIterator = currentRow.iterator();
			 Cell currentCell = cellIterator.next();
             if (currentCell.getCellType() == CellType.STRING) {
                 System.out.print(currentCell.getStringCellValue() + " -- ");
             } else if (currentCell.getCellType() == CellType.NUMERIC) {
                 System.out.print(currentCell.getNumericCellValue() + " -- ");
             }
             System.out.println();
		}

	
	

	}

}
