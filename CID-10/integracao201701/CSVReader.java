package integracao201701;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader 
{
	public static void main(String[] args ) throws IOException
	{
	
		String keyWord = "dengue";
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alunoinf\\Documents\\GitHub\\integracao201701\\CID-10\\integracao201701\\CID-10.CSV"));
		String line = "";
		
		while ((line = br.readLine()) != null) {
			
			if( line.contains( keyWord))
			{
				System.out.println(line);
			}
		    // "," ou ";" de acordo com o arquivo
		   // String[] row = line.split(";");
	
		   // System.out.println(row[0] + " - " + row[1]);
			
			//System.out.println( line);
		}
	
	}
}
