package com.makemytrip;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlightVerification {
	
	public static WebDriver driver;
	@BeforeMethod
	  public void setUp() {
		EdgeOptions options = disableNotifications();
		driver= new EdgeDriver(options);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void verifyFlights() throws InterruptedException {
		driver.findElement(By.xpath("//li[@class='menu_Flights']")).click();
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("New York"+Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[@class='blackText makeFlex hrtlCenter']")).click();
		
	}

	
	@AfterMethod
	
      public void tearDown() {
		driver.quit();
	}
	public EdgeOptions  disableNotifications() {
		// Create an instance of EdgeOptions class
		EdgeOptions options = new EdgeOptions();

		// Add edge arguments to disable notification
		options.addArguments("--disable-notifications");
		return options;

	}
	
}
