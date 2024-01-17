package selenium.studies;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestMouseActions {
	public static WebDriver driver;
	public static void setUp() {
		driver = new EdgeDriver();
		driver.get("https://www.way2automation.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public static void tearDown() {

		driver.quit();
	}
	
	public void mouseActions() {
		Actions action = new Actions(driver);
		WebElement act= driver.findElement(By.xpath("//li[@id='menu-item-27580']//span[@class='menu-text'][normalize-space()='All Courses']"));
		action.click(act).build().perform();
		WebElement act2= driver.findElement(By.xpath("//li[@id='menu-item-27581']//span[@class='menu-text'][normalize-space()='Lifetime Membership']"));
	
		
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		TestMouseActions tc = new TestMouseActions();
		setUp();
		tc.mouseActions();
		tearDown();
	}

}
