package selenium.studies;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDropdown {
	public static WebDriver driver;
	public static void setUp() {
		driver = new EdgeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public static void tearDown() {

		driver.quit();
	}
	public void dropDown() {
		
		WebElement drop = driver.findElement(By.xpath("//select[@name='language']"));
		Select select = new Select(drop);
		//select.selectByVisibleText("Deutsch");
		getAllOptions(select);
		
	}
	public static void getAllOptions(Select se) {
		List<WebElement> li=se.getOptions();
		for(WebElement ele: li) {
	System.out.println(ele.getText()) ;
	}
		
	}
	//find the count of links , print the text along with URL 
	public void getAllLinks() {
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(WebElement el : links) {
			System.out.println(el.getText()+ " URL: " +el.getAttribute("href"));
			
		}
	}

	public static void main(String[] args) {
		TestDropdown td= new TestDropdown();
		setUp();
		td.getAllLinks();
		tearDown();

	}

}
