package integracao201701;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Searcher 
{
	public ArrayList<String> search(BufferedReader br, String keyword )
	{
		String[] keywordsList = getKeywordsList( keyword );
		return null;
	}
	
	public String[] getKeywordsList( String keyword )
	{
		String[] keywordsList = keyword.split(" ");
		
		return keywordsList;
	}
	
	public ArrayList<String> searchKeyword(BufferedReader br, String keyword ) throws IOException 
	{
	
		String line = "";
		ArrayList<String> results = new ArrayList<String>();
		
		while ((line = br.readLine()) != null) {
			
			if( line.contains( keyword))
			{
				results.add(line);
			}
		}
		return results;
	}
}