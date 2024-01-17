package parrallelexecution;

import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParrallelTenstNG {
	
	@Parameters({"browser"})
	@Test(invocationCount = 3)
	public void checkParrell(String browser) throws InterruptedException {
		Date d = new Date();
		System.out.println("Browser : " +browser +"Execution Time: " +d);
		Thread.sleep(2000);
	}

}
