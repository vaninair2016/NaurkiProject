import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileReadAndWrite {

	public static void main(String[] args) throws IOException {
         
       File tf= new File(System.getProperty("user.dir")+"\\src\\main\\java\\sample.txt");
       tf.createNewFile();
       FileWriter fw = new FileWriter(System.getProperty("user.dir")+"\\src\\main\\java\\sample.txt");
       BufferedWriter fwrite = new BufferedWriter(fw);
       fwrite.write("hello dear");
       fwrite.flush();
      
	}

}
