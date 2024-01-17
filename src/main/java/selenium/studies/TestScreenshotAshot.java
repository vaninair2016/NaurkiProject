package selenium.studies;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.common.io.Files;

public class TestScreenshotAshot {
	public static WebDriver driver;
	public static void setUp() throws IOException {
		driver = new EdgeDriver();
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		driver.manage().window().maximize();
		getScreenShot();
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

	public static void getScreenShot() throws IOException {
    Date d = new Date();
    String scFormat=d.toGMTString().toString().replace(" ", "_").replace(":", "_");
    
	File sc=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String userDir= System.getProperty("user.dir");
	String targetPath= userDir+"\\screenshots\\"+scFormat+".png";
	FileUtils.copyFile(sc, new File(targetPath));
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		TestScreenshotAshot tc = new TestScreenshotAshot();
		setUp();
		//tc.getScreenShot();
		tearDown();
	}

}
