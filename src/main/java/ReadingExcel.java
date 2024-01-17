import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		File f = new File(System.getProperty("user.dir")+"\\csvfiles\\Study Number examples.xls");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet0 = wb.getSheetAt(0);
//		Row row0= sheet0.getRow(0);
//		Cell cell0= row0.getCell(0);
		// to iterate thru all the values in a excel
		String longestString = "";
		for(Row row : sheet0) {
			for(Cell cell : row) {
				if(cell.getCellType()==CellType.STRING)	{
					String cellValue= cell.getStringCellValue();
					if(cellValue.length()>longestString.length()) {
						longestString= cellValue;
						
					}
				}
		
					
				}
			}
		System.out.println(longestString +":: "+ longestString.length());
		
		
		

	}

}
