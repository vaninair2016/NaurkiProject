package imp.LoginTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestcase {
	WebDriver driver;
	@BeforeMethod
	public void loginNaukri() {
		driver= new EdgeDriver();
		driver.get("https://www.naukri.com/nlogin/login");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@title='Jobseeker Login']")).click();
		driver.findElement(By.id("usernameField")).sendKeys("vaninair2016@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("Haicutey@143");
		try {
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		}
	@Test
	public void searchJobQA() {
		
		driver.findElement(By.xpath("//span[text()='Search jobs here']")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'Enter keyword / ')]")).sendKeys("Software testing, Test Engineer, Automation Testing, ");
		WebElement expDropdown=driver.findElement(By.xpath("//input[@placeholder='Select experience']"));
		Select dropdown = new Select(expDropdown);
		dropdown.selectByVisibleText("9 years");
		driver.findElement(By.xpath("//span[@class='ni-gnb-icn ni-gnb-icn-search']")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	

}
