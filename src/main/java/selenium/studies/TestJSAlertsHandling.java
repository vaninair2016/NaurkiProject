package selenium.studies;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestJSAlertsHandling {
	public static WebDriver driver;
	public static void setUp() {
		driver = new EdgeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public static void tearDown() {

		driver.quit();
	}
	
	public void handleAlerts() {
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
//		Alert alert= driver.switchTo().alert();
//		System.out.println(alert.getText());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		
	
		
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		TestJSAlertsHandling tc = new TestJSAlertsHandling();
		setUp();
		tc.handleAlerts();
		tearDown();
	}

}
