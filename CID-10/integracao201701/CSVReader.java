package integracao201701;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class CSVReader 
{
	public static void main(String[] args ) throws IOException
	{
	
		String keyWord = "dengue";
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alunoinf\\Documents\\GitHub\\integracao201701\\CID-10\\integracao201701\\CID-10.CSV"));
		ArrayList<String> results = new ArrayList<String>();
		Searcher searcher = new Searcher();
		
		results = searcher.searchKeyword(br, keyWord);
		
		Iterator<String> iterator = results.iterator();
		
		while(iterator.hasNext())
		{
			System.out.println( iterator.next());
		}
		

	
	}
}
