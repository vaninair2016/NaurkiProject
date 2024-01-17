package log4j.tests;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogWriting {
	
	public static Logger log = Logger.getLogger(LogWriting.class.getName());

	public static void main(String[] args) {
		PropertyConfigurator.configure(System.getProperty("user.dir")+"src/main/java/log4j/tests");
		log.info("This is information");
		log.error("This is an error message");
		



}
}
