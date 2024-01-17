package parametrization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterizationClass {
	
	@Test(dataProvider="dataProviderMethod")
	
	public void testMethod(String username,String password) {
		System.out.println(username + "---" +password);
	}
	@DataProvider
	public Object[][] dataProviderMethod(){
		
		Object[][] obj = new Object[3][2];
		obj[0][0]="vani";
		obj[0][1]="vani@123";
		
		obj[1][0]="setu";
		obj[1][1]="setu@123";
		
		obj[2][0]="cuckoo";
		obj[2][1]="cuckoo@123";
				
		return obj;
		
	}

}
