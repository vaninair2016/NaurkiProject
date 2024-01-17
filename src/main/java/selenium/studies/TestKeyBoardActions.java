package selenium.studies;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestKeyBoardActions {
	public static WebDriver driver;
	public static void setUp() {
		driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public static void tearDown() {

		driver.quit();
	}
	
	
	public void readExcel() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir") + "\\csvfiles\\Subject Data Review - IP Data Report.xlsx"));
		Workbook wb =WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Cell cell = row.getCell(0);
			String text = cell.getStringCellValue();
			search(text);
		}
		fis.close();
		wb.close();
	}
	
	
	private void search(String text) {
		WebElement search= driver.findElement(By.xpath("//textarea[@name='q']"));
		Actions action = new Actions(driver);
		action.moveToElement(search).click()
		.sendKeys(text)
		.sendKeys(Keys.ENTER)
		.perform();
		
		
	}
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		TestKeyBoardActions tc = new TestKeyBoardActions();
		setUp();
		tc.readExcel();
		tearDown();
	}

}
