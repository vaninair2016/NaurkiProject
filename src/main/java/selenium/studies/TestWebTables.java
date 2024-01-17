package selenium.studies;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TestWebTables {
	public static WebDriver driver;
	public static void setUp() {
		driver = new EdgeDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public static void tearDown() {

		driver.quit();
	}
	public void handleWebTables() {
		WebElement tbody= driver.findElement(By.xpath("//table[@class='dataTable']//tbody"));
		List<WebElement> allrows= driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr"));
		
		for(int i=1;i<allrows.size();i++) {
			String s= driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr[i]//td[i]")).getText();
			if (s.equalsIgnoreCase("Mangalore Refine")) {
				System.out.println(driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr[i]//td[5]")).getText()); 
			}
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		TestWebTables tc = new TestWebTables();
		setUp();
		tc.handleWebTables();
		tearDown();
	}

}
