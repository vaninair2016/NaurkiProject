package imp.LoginTestcases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CompareCSV {
    public static void main(String[] args) throws IOException, CsvException {
        CSVReader reader1 = new CSVReader(new FileReader("C:\\Users\\q1052077\\Documents\\SeleniumProject\\NaukriProjectTest\\csvfiles\\geography.csv"));
        CSVReader reader2 = new CSVReader(new FileReader("C:\\Users\\q1052077\\Documents\\SeleniumProject\\NaukriProjectTest\\csvfiles\\Geographyformal.csv"));

        List<String[]> fileOne = reader1.readAll();
        List<String[]> fileTwo = reader2.readAll();
        System.out.println(fileOne.size());
        System.out.println(fileTwo.size());

        for (String[] record : fileTwo) {
            if (!fileOne.contains(record)) {
            	
                System.out.println(Arrays.toString(record));
            }
        }
        
        reader1.close();
        reader2.close();
    }
}
