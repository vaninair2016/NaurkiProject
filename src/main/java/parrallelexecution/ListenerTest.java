package parrallelexecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ListenerTest {
	public static WebDriver driver ;
	@Test
	public void testMethodGoogle() {

 driver = new EdgeDriver();
	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	}
	@Test
	public void testMethodGmail() {

	driver = new EdgeDriver();
	driver.get("https://www.gmail.com/");
	driver.manage().window().maximize();
	}
	
}
