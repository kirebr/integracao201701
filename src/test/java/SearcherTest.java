import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SearcherTest {

	Searcher searcher = new Searcher();
	BufferedReader br;
	ArrayList<String> results;

	public SearcherTest() throws FileNotFoundException, URISyntaxException
	{
		br = new BufferedReader(new FileReader("src//main//resources//CID-10.csv"));
	}
	
	@After
	public void setUp()
	{
		results.clear();
	}
	
	@Test
	public void testResultNotNull() throws IOException 
	{		
		results = searcher.searchKeyword(br, "Macumba");
		assertNotNull( results );
	}
	
	@Test
	public void testNumberOfResultsIsRight() throws IOException
	{
		results = searcher.searchKeyword(br, "dengue");
		
		assertEquals(results.size(), 4);
	}
	
	@Test
	public void StringResultIsRight() throws IOException
	{
		results = searcher.searchKeyword(br, "dengue");
		
		String result = results.get(0);
		
		assertTrue( result.contains( "dengue"));
	}
	
	@Test
	public void NumberOfResultsFromSearchMethodTest() throws IOException
	{
		String[] keyword = {"Colera", "devida", "Vibrio", "cholerae"};
		
		results = searcher.search(br, keyword );
		
		assertEquals( results.size(), 2 );

	}
	
	@Test
	public void searchMethodTest1() throws IOException
	{
		String[] keyword = {"Colera", "devida", "Vibrio", "cholerae"};	
		results = searcher.search(br, keyword );		
		assertTrue( results.contains( "A000,C�lera devida a Vibrio cholerae 01") && results.contains( "A001,C�lera devida a Vibrio cholerae 01"));
	}
	
	@Test
	public void searchMethodTest2() throws IOException
	{
		String[] keyword = {"M9989/1", "S�ndrome", "mielodispl�sica", "SOE"};	
		results = searcher.search(br, keyword );		
		assertTrue( results.contains( "M9989/1,S�ndrome mielodispl�sica SOE"));
	}
	
	@Test
	public void allLinesAreLoaded() throws IOException
	{
		searcher.load();
		results = searcher.getListOfDiseases();
		
		
		assertEquals( results.size(), 10943 );
	}
	
	/*
	@Test
	public void emptyStringSearch() throws IOException
	{
		String[] keyword = {"", };	
		results = searcher.search(br, keyword );	
		System.out.println( results.size());
		assertTrue( results.isEmpty());
	} */
}
