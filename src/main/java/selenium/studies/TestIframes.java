package selenium.studies;

import java.time.Duration;
import java.util.Iterator;
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

public class TestIframes {
	public static WebDriver driver;
	public static void setUp() {
		driver = new EdgeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public static void tearDown() {

		driver.quit();
	}
	
	public void handleFrames() {
		//driver.switchTo().frame(0);
		WebElement ele= driver.findElement(By.xpath("//button[@id='runbtn']"));
       List<WebElement> frames= driver.findElements(By.tagName("iframe"));
       System.out.println(frames.size());
       for(WebElement e : frames) {
    	   System.out.println(e.getAttribute("id"));
       }
       driver.switchTo().frame("iframeResult");
       driver.switchTo().defaultContent();
       ele.click();
	}	
	
	
	public static void main(String[] args) throws InterruptedException {
		TestIframes tc = new TestIframes();
		setUp();
		tc.handleFrames();
		tearDown();
	}

}
