import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFiles {

	public static void main(String[] args) throws IOException {
		// connecting Streams
		File f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\sampletext.csv");
		FileReader fr= new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		// read excel 
		String line = null;
		
		while((line=br.readLine())!=null) {
		System.out.println(line); // reads the first line 
		
		}
		br.close();

	}

}
