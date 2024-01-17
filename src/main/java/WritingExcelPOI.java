import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcelPOI {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook(); // it can create both .xls and .xlsx files(XSSF API)
		XSSFSheet sheet = wb.createSheet("firstsheet"); // creating a sheet in workbook
		Row row0= sheet.createRow(0); 
		Cell cellA= row0.createCell(0);
		Cell cellB = row0.createCell(1);
		cellA.setCellValue("A cell");
		cellB.setCellValue("B Cell");
		
		// connecting streams 
		File f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\poitest.xls");
		FileOutputStream fo = new FileOutputStream(f);
		//write in above file 
		wb.write(fo);
		fo.close();
		
	}

}
