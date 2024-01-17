

	
	import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Cookie.Builder;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.IntStream;


	public class TestClassSampleSalesForce2 {

	    private WebDriver driver;
	    public Properties prob = new 	Properties();


@BeforeTest
	    public void setUp(){
	        driver= new EdgeDriver(edgeOptionTest());
	        driver.get("https://dtmsformalrbmcrac.lightning.force.com/lightning");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.findElement(By.id("username")).sendKeys("rbmsysadmin@rbm1.1.formal");
	        driver.findElement(By.id("password")).sendKeys("rbm123456");
	        driver.findElement(By.xpath("//input[@name='Login']")).click();
	        System.out.println(driver.getTitle());


	    }
	    @Test
	    
	    public void getMonitoringApp(int invocationCount) throws InterruptedException {
	    	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	    	driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']")).sendKeys("Alerts");
	    	driver.findElement(By.xpath("//b[text()='Alerts']")).click();
	    	WebElement sort=driver.findElement(By.xpath("//lightning-button-icon[@class='dropbtn slds-p-right_xxx-small']//button[@type='button']"));
	    	//waitForElementToBeClickable(driver,sort,20);
	    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
	    	wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("lightning-spinner")));
	    	sort.click();
	    	WebElement  search=driver.findElement(By.xpath("//span[text()='Just a Study']"));
	    	//search.sendKeys("IQVIA-STUDY-501"+Keys.ENTER);
	    	highlightElement(driver,search);

    	    WebElement chekbox=driver.findElement(By.xpath("//th[@class='chkHeader']//span[@class='slds-checkbox_faux']"));
    	    highlightElement(driver,chekbox);
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    	wait.until(ExpectedConditions.elementToBeClickable(chekbox));
	    	chekbox.click();
	    	Thread.sleep(5000);
//	    	safeClickOnElement(driver, chekbox, 10);
	    	WebElement changeOwner = driver.findElement(By.xpath("//div[@class='slds-col slds-size_9-of-12 slds-m-top_xx-small slds-scollable_y split-element-css']//lightning-layout-item[@class='slds-p-right_none slds-m-right_none slds-p-left_small']"));
    	     changeOwner.click();
    	     driver.findElement(By.xpath("//button[contains(@name,'userComboBox')]")).click();
    	     Thread.sleep(10000);
    	     
    	     
    	    		 WebElement cml=driver.findElement(By.xpath("//lightning-base-combobox-item[1]"));
    	     cml.click();
    	     
    	     Thread.sleep(10000);
    	     driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand'][normalize-space()='Change Owner']")).click();
    	     String original=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
    	     assertTrue(original.contains("Owner has been changed"), "Test didn't pass");
    	    

	    }
	    
	    public static void highlightElement(WebDriver driver, WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	    }

	    public void readPlannerHomePage() {
	    	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	    	driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']")).sendKeys("RBQM Planner");
	    	driver.findElement(By.xpath("//b[text()='RBQM Planner']")).click();
//	    	WebElement dropdDown=driver.findElement(By.xpath("//button[@title='Show Navigation Menu']"));
//	    	safeClickOnElement(driver,dropdDown,10);
//	    	driver.findElement(By.xpath("//span[text()='Home']")).click();
	    	driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']")).sendKeys("Home");
	    	driver.findElement(By.xpath("//b[text()='Home']")).click();
	    	
	    }
	    @AfterMethod

	    public void tearDown(){
	        driver.quit();
	    }
	    

	    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    }
	    public static void safeClickOnElement(WebDriver driver, final WebElement element, int timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        wait.until(new ExpectedCondition<Boolean>() {
	            @Override
	            public Boolean apply(WebDriver driver) {
	                try {
	                    element.click();
	                    return true;
	                } catch (ElementClickInterceptedException e) {
	                    return false;
	                }
	            }
	        });
	    }
	    
	    public EdgeOptions edgeOptionTest() {
	    	EdgeOptions options = new EdgeOptions();
	    	options.addArguments("disable-infobars");
	    	options.setHeadless(true);
	    	return options;
	    }
	    //to read object DB 
 public void loadPropertiesFile() {
			
			File propfile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\objectdb.properties");
			
			try {
				
			FileInputStream fis= new FileInputStream(propfile);
			prob.load(fis);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	 }

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		 TestClassSampleSalesForce2 baseTests = new TestClassSampleSalesForce2();
	        baseTests.setUp();
	       baseTests.getMonitoringApp(2);
	        //baseTests.readPlannerHomePage();
	        baseTests.tearDown();
	}

}
