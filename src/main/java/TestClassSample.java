

	
	import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Cookie.Builder;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;


	public class TestClassSample {

	    private WebDriver driver;
	    //protected HomePage homePage;


	    public void setUp(){
	        driver= new EdgeDriver(edgeOptionTest());
	        driver.get("https://the-internet.herokuapp.com/tables");
	        driver.manage().window().maximize();
	        System.out.println(driver.getTitle());


	    }

	    public void tearDown(){
	        driver.quit();
	    }
	    
	    public void readTable() {
	    	WebElement table=driver.findElement(By.id("table1"));
	    	List<WebElement> allRows = table.findElements(By.tagName("tr"));

	    	// And iterate over them, getting the cells
	    	for (WebElement row : allRows) {
	    	    List<WebElement> cells = row.findElements(By.tagName("td"));

	    	    // Print the contents of each cell
	    	    for (WebElement cell : cells) {
	    	        System.out.println(cell.getText());
	    	    }
	    	}
	    }
	    
	    public void verifyHover(int index) {
	    	driver.findElement(By.linkText("Hovers")).click();
	    	WebElement figure= driver.findElements(By.xpath("//div[@class='figure']//img")).get(index-1);
	    	Actions actions = new Actions(driver);
	    	actions.moveToElement(figure).perform();
	    	String message =driver.findElement(By.xpath("//div[@class='figcaption'][1]")).getText();
	    	WebElement link = driver.findElement(By.xpath("//a[text()='View profile']"));
	    	//Assert.assertEquals(message,)
	    	//System.out.println(driver.findElement(By.xpath("//div[@class='figcaption'][1]")).getText());
	    	System.out.println(link.getAttribute("href"));
	    }
	    public void checkKeyPress() {
	    	driver.findElement(By.xpath("//a[text()='Key Presses']")).click();
	    	WebElement ele= driver.findElement(By.xpath("//input[@id='target']"));
	    	ele.sendKeys("A" + Keys.BACK_SPACE+ "B");
	    	WebElement hoverText=driver.findElement(By.xpath("//p[@id='result']"));
	    	System.out.println(hoverText.getText());
	    	SoftAssert softassert= new SoftAssert();
	    	softassert.assertEquals(hoverText.getText(), "You entered: BACK_SPACE","Test didnt pass");
	    	
	    }
	    
	    public void clickJSAlert() {
	    	driver.findElement(By.xpath("//a[text()='JavaScript Alerts']")).click();
	    	driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
	    	//driver.switchTo().alert().accept();
	    	//Alert alert= new Alert();
	    	String al=driver.switchTo().alert().getText();
	    	System.out.println(al);
	    	driver.switchTo().alert().accept();
	    	SoftAssert softassert = new SoftAssert();
	    	softassert.assertTrue(true,"Alert doesnt exist");
	    	softassert.assertAll();
	    	// to click on js confirm 
	    	driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
	    	System.out.println(driver.switchTo().alert().getText());
	    	driver.switchTo().alert().dismiss();
	    	Assert.assertEquals(false, "Alert not found");
	    }
	    
	    public void fileUploadCheck() throws AWTException {
	    	driver.findElement(By.xpath("//a[text()='File Upload']")).click();
	    	driver.findElement(By.xpath("//input[@name='file']")).submit();
	   
//	    	// copying File path to Clipboard
   	Robot rb = new Robot();
        StringSelection str = new StringSelection("C:/Users/q1052077/Documents/SeleniumProject/NaukriProjectTest/csvfiles/geography.csv");
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	     
//	         // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
         rb.keyPress(KeyEvent.VK_V);
//	     
//	        // release Contol+V for pasting
	        rb.keyRelease(KeyEvent.VK_CONTROL);
	        rb.keyRelease(KeyEvent.VK_V);
//	     
//	        // for pressing and releasing Enter
	        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
	    	//path.sendKeys("C:/Users/q1052077/Documents/SeleniumProject/NaukriProjectTest/csvfiles/geography.csv");
	    	driver.findElement(By.xpath("//input[@type='submit']")).submit();
	    }
	    
	    public void handleFrame() throws InterruptedException {
	    	driver.findElement(By.xpath("//a[text()='WYSIWYG Editor']")).click();
	    	//WebElement ele= driver.findElement(By.className("mce-content-body "));
	    	driver.switchTo().frame("mce_0_ifr");
	    	WebElement ele= driver.findElement(By.className("mce-content-body"));
	    	ele.clear();
	    	Thread.sleep(1000);
	    	ele.sendKeys( "Hello");
	    	Thread.sleep(1000);
	    	driver.findElement(By.xpath("//button[@title='Decrease indent']")).click();
	    }
	    
	   
	    public void testJavaScript() throws InterruptedException {
	    	driver.findElement(By.xpath("//a[text()='Large & Deep DOM']")).click();
	    	WebElement ele= driver.findElement(By.id("large-table"));
	    	String arg= "arguments[0].scrollIntoView();";
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript(arg, ele);
	    	Thread.sleep(5000);
	    }
	    
	    public void testJavaScript2( int index) throws InterruptedException {
	    	driver.findElement(By.xpath("//a[text()='Infinite Scroll']")).click();
	    	List ele = driver.findElements(By.xpath("//div[@class='jscroll-added']"));
	    	String arg = "window.scrollTo(0,document.body.scrollHeight)";
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	while (ele.size() < index)
	    	{
	    	js.executeScript(arg);
	    	
	    	}
	    	System.out.println(ele.size());
	    }
	    
	    public void windowHandling() throws InterruptedException {
	    	
	    	driver.navigate().to("https://the-internet.herokuapp.com/abtest");
	    	Thread.sleep(5000);
	    	driver.switchTo().newWindow(WindowType.TAB);
	    	driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
	    	driver.navigate().back();
	    	Thread.sleep(5000);
	    	driver.navigate().refresh();
	    	Thread.sleep(5000);
	    	
	    	
	    }
	    
	    public void windowHandling2() throws IOException {
	    	driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
	    	driver.findElement(By.xpath("//a[text()='Click Here']")).click();
	    	
	    	String parent=driver.getWindowHandle();
	    	Set<String> windows=driver.getWindowHandles();
	    	System.out.println(windows.size());
	    	//String se=driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
			//System.out.println(se);
	    	for(String s : windows) {
	    		    System.out.println("Switching to window :" +s);
	    		
	    			driver.switchTo().window(s);
	    			
	    		   if(!s.equals(parent)) { 
	    			   String se=driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
	    			 SoftAssert softassert=new SoftAssert();
	    			softassert.assertEquals(se,"New Window","Not passed");
	    			softassert.assertAll();
	    			//takeScreenShot();
	    		   }
	    		
	    	}
	    	driver.switchTo().window(parent);
	    	takeScreenShot();
	    }
	    
	    public  void takeScreenShot() throws IOException {
	    	Random rd= new Random();
	    	IntStream a=rd.ints();
	    	TakesScreenshot camera= (TakesScreenshot)driver;
	    	File sc=camera.getScreenshotAs(OutputType.FILE);
	    	Files.move(sc, new File("C:/Users/q1052077/Documents/SeleniumProject/NaukriProjectTest/test-output/scs/"+a+".png"));
	    	//System.out.println(sc.getAbsolutePath());
	    }
	    
	    public EdgeOptions edgeOptionTest() {
	    	EdgeOptions options = new EdgeOptions();
	    	options.addArguments("disable-infobars");
	    	//options.setHeadless(true);
	    	return options;
	    }
	    
	    public void setCookie() {
	    	Cookie cookie = new Cookie.Builder("setu", "143")
	    			.domain("the-internet.herokuapp.com")
	    			.build();
	    	driver.manage().addCookie(cookie);
	    			
	    }

	    public void testMethod(){
	        driver= new EdgeDriver();
	        driver.get("https://the-internet.herokuapp.com/");
	        driver.manage().window().maximize();
	        driver.findElement(By.linkText("Shifting Content")).click();
	        driver.findElement(By.partialLinkText("Menu Element")).click();
	        List<WebElement> childa= driver.findElements(By.xpath("//ul//li//a"));
	        System.out.println(childa.size());
	        System.out.println(childa.get(0));
	        driver.quit();
	    }
	    
	    public void writeToExcel() throws IOException {
	    	XSSFWorkbook workbook = new XSSFWorkbook();
	    	XSSFSheet sheet = workbook.createSheet("Table data");
	    	WebElement table = driver.findElement(By.id("table1"));
	    	List<WebElement> allRows = table.findElements(By.tagName("tr"));
	    	int rowNum =0;
	    	
	    	for(WebElement row: allRows) {
	    		XSSFRow sheetRow = sheet.createRow(rowNum++);
	    		List<WebElement> cells = row.findElements(By.tagName("td"));
	    	
	    	int cellNum = 0;

            // Print the contents of each cell
            for (WebElement cell : cells) {
                // Create a new cell in the row
                XSSFCell sheetCell = sheetRow.createCell(cellNum++);

                // Set the value of the cell to the text of the HTML cell
                sheetCell.setCellValue(cell.getText());
            }
            
            FileOutputStream fileOut = new FileOutputStream("workbook.xlsx");
            workbook.write(fileOut);
            fileOut.close();

            // Closing the workbook
            workbook.close();
	    	} 
	    	
	    }

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		 TestClassSample baseTests = new TestClassSample();
	        baseTests.setUp();
	        //baseTests.verifyHover(2);
	        //baseTests.checkKeyPress();
	        //baseTests.clickJSAlert();
	        //baseTests.fileUploadCheck();
	        //baseTests.handleFrame();
	        //baseTests.verifyExplicitWait();
	        //baseTests.testJavaScript();
	        //baseTests.testJavaScript2(5);
	        //baseTests.windowHandling();
	        //baseTests.setCookie();
	        //baseTests.windowHandling2();
	        baseTests.writeToExcel();
	        baseTests.tearDown();
	}

}
