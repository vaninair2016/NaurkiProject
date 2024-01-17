import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsCheck {
	WebDriver driver;
	
	public void setUp(){
        driver= new EdgeDriver(edgeOptionTest());
        driver.get("https://rbminsprintqa-dev-ed.lightning.force.com/lightning/page/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys("vanimol.s@rbm.com");
        driver.findElement(By.id("password")).sendKeys("Nov@2023");
        driver.findElement(By.xpath("//input[@name='Login']")).click();
        System.out.println(driver.getTitle());
}
	public void checkRelativeLocators() {
		WebElement home = driver.findElement(By.xpath("//span[text()='Home']"));
		home.
		WebElement spans=driver.findElement(RelativeLocator.with(By.tagName("span")).below(home));
		System.out.println(spans);
	}
	   public EdgeOptions edgeOptionTest() {
	    	EdgeOptions options = new EdgeOptions();
	    	options.addArguments("disable-infobars");
	    	options.setHeadless(true);
	    	return options;
	    }
	   public void tearDown(){
	        driver.quit();
	    }
	    

	public static void main(String[] args) {
		RelativeLocatorsCheck RelativeLocatorsCheck = new RelativeLocatorsCheck();
		RelativeLocatorsCheck.setUp();
		RelativeLocatorsCheck.checkRelativeLocators();
		RelativeLocatorsCheck.tearDown();

	}

}
