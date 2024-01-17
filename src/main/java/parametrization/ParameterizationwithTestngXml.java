package parametrization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizationwithTestngXml {

	@Parameters({"browser","env"})
	@Test 
	public void checkParameter(String browser,String env) {
		System.out.println(browser+"----"+env);
		
	}
}
