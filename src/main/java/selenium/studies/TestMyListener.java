package selenium.studies;

import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestMyListener implements WebDriverListener{
	@Test
	public void testCase1() {
		String expected= "This is expected";
		String actual= "This is actual";
		//Assert.assertEquals(expected, actual);
		//Assert.fail("I am failing this");
		SoftAssert sf= new SoftAssert();
		sf.assertEquals(expected, actual, "SoftAssert implemented");
		sf.fail("I am failing this");
		System.out.println("Test continued");
		sf.assertAll();
	}


}
