package selenium.studies;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

public class TestTabsPopups {
	public static WebDriver driver;
	public static void setUp() {
		driver = new EdgeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public static void tearDown() {

		driver.quit();
	}
	
	public void handleWindows() {
		
		driver.findElement(By.xpath("//a[@title='Remote']")).click();
		//driver.findElement(By.xpath("//a[@id='login_Layer']")).click();
		WebElement ba = driver.findElement(By.xpath("//a[text()='Business Analyst'][1]"));
		ba.click();
		Set<String> handles= driver.getWindowHandles();
		System.out.println(handles.size());
		Iterator<String> iterate=handles.iterator();
		String firstHandle=iterate.next();
		String secondHandle=iterate.next();
		
		System.out.println(firstHandle);
		System.out.println(secondHandle);
		System.out.println(driver.getTitle());
		driver.switchTo().window(secondHandle);
		System.out.println(driver.getTitle());
		
	
		
	}	
	
	
	public static void main(String[] args) throws InterruptedException {
		TestTabsPopups tc = new TestTabsPopups();
		setUp();
		tc.handleWindows();
		tearDown();
	}

}
