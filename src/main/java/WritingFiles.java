import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WritingFiles {

	public static void main(String[] args) throws IOException {
		//Stream connectivity
      File 	f= new File(System.getProperty("user.dir")+"\\src\\main\\java\\sampletext.csv");
      FileWriter fw = new FileWriter(f,false);
      BufferedWriter bw = new BufferedWriter(fw);
      
      //Writing inside file created above 
      for(int i=0;i<5;i++) {
    	  for(int j=0;j<4;j++) {
    		  int num = (int) (Math.random()*100);
    		  bw.write(num+ ",");
    		 
    		  
    	  }
    	  bw.newLine();
      }
//      bw.write("Vani");
//      bw.newLine();
//      bw.write("Cuckoo");
      //close the streams 
      bw.close();
      System.out.println("File is created ");     
	}

}
