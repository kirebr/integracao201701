package br.inf.ufg;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.ListIterator;

public class CID10 
{
	private BufferedReader br;
	private ArrayList<String> listOfCID10Diseases = new ArrayList<String>();
	private ArrayList<String> normalizedListOfCID10Diseases = new ArrayList<String>();
	
	//M�todo load carrega arquivo CID10.csv dentro de um arraylist de strings, remove as virgulas e normaliza as linhas.
	public void load() throws IOException
	{
		InputStream configStream = getClass().getResourceAsStream("CID-10.csv");
		br = new BufferedReader(new InputStreamReader(configStream));
		
		String line;
		
		while(( line = br.readLine()) != null )
		{
			//Elimina a virgula que separa o c�digo e a descri��o da doen�a no arquivo csv
			line = line.replace(',', ' ');
			normalizedListOfCID10Diseases.add(normalizeString(line));
			listOfCID10Diseases.add( line );	
		}
		
		br.close();
	}
	
	public void unload() throws Throwable
	{
		finalize();
	}
	
	public ArrayList<String> search(String[] keywords )
	{
		String line;
		ArrayList<String> results = new ArrayList<String>();
		ListIterator<String> iteradorLista = normalizedListOfCID10Diseases.listIterator();
		
		String[] normalizedKeywords = normalizeStringArray(keywords);
		
		while( iteradorLista.hasNext() )
		{
			line = iteradorLista.next();
			
			boolean lineMatch = false;
			
			for(String word : normalizedKeywords )
			{
				if( line.contains(word))
				{
					lineMatch = true;
				}
				else
				{
					lineMatch = false;
					break;
				}
			} 
			
			if( lineMatch == true )
			{
				results.add(listOfCID10Diseases.get(iteradorLista.nextIndex() - 1));
			}		
		}
		
		if( results.isEmpty() ) {
			return null;
		}
		else {
			return results;
		}
	}
	
	// Normaliza as strings em um array de Strings
	private static String[] normalizeStringArray(String[] stringArray) {
		String[] normalizedStringArray = new String[stringArray.length];
		int i = 0;
		
		for(String word : stringArray )
		{
			normalizedStringArray[i] = normalizeString(word);
			i++;
		}
		
		return normalizedStringArray;
	}
	
	// Remove acentos e deixa todas as letras em caixa baixa.
	private static String normalizeString(String str) {
		return removeAccent(str).toLowerCase();
	}
	
	// Remove acentos da String
	private static String removeAccent(String str) {
	    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
}