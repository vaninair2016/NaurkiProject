package imp.LoginTestcases;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CompareCSV1 {
    public static void main(String[] args) throws IOException {
        CSVParser parser1 = new CSVParser(new FileReader("C:\\Users\\q1052077\\Documents\\SeleniumProject\\NaukriProjectTest\\csvfiles\\geography.csv"), CSVFormat.DEFAULT);
        CSVParser parser2 = new CSVParser(new FileReader("C:\\Users\\q1052077\\Documents\\SeleniumProject\\NaukriProjectTest\\csvfiles\\Geographyformal.csv"), CSVFormat.DEFAULT);

        List<CSVRecord> fileOne = parser1.getRecords();
        List<CSVRecord> fileTwo = parser2.getRecords();

        for (CSVRecord record : fileTwo) {
            if (!fileOne.contains(record)) {
                System.out.println(record);
            }
        }

        for (CSVRecord record : fileOne) {
            if (!fileTwo.contains(record)) {
                System.out.println(record);
            }
        }

        parser1.close();
        parser2.close();
    }
}

