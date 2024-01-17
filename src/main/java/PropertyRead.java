import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyRead {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream((System.getProperty("user.dir"))+"\\src\\main\\java\\objectdb.properties");
        prop.load(fis);
        System.out.println(prop.getProperty("Home"));
        System.out.println(prop.getProperty("menuDropdown"));
        System.out.println(System.getProperty("user.dir"));
        
	}

}
