package createDB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AdddingDataFromTxtToDB {

	public static void main(String[] args) throws IOException {

		FileReader fileReader = new FileReader("e://varu/a.txt");;
	
        //@SuppressWarnings("unused")
		BufferedReader bf=new BufferedReader(fileReader);
        String str=null;
        while((str=bf.readLine())!=null)
        {
        	
            System.out.println("Data is: " + str);
		}
        fileReader.close();
        
        
        
	}

}
