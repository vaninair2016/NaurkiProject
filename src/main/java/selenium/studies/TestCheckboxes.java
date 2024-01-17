package selenium.studies;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TestCheckboxes {
	public static WebDriver driver;
	public static void setUp() {
		driver = new EdgeDriver();
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public static void tearDown() {

		driver.quit();
	}
	
	public void findAllCheckboxes() throws InterruptedException {
		List<WebElement> allchk= driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(allchk.size());
		for(int i=0;i<allchk.size();i++) {
			if (!allchk.get(i).isSelected()) {
			    allchk.get(i).click();
			}

			System.out.println(allchk.get(i).isSelected());
			//System.out.println(allchk.get(i).getAttribute("value"));
		}
	}

	public static void main(String[] args) throws InterruptedException {
		TestCheckboxes tc = new TestCheckboxes();
		setUp();
		tc.findAllCheckboxes();
		tearDown();
	}

}
