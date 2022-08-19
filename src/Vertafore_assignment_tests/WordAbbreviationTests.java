package Vertafore_assignment_tests;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;

import Vertafore_Assignments.WordAbbreviation;

public class WordAbbreviationTests {
	
	WordAbbreviation testObj = new WordAbbreviation();
	
	@Test
	public void checkIfWordAbbreviationsCorrect()
	{
		String word  = "localization";
		String expectedAbbreviation = "l10n";
		String generatedOutput = testObj.getWordAbbreviation(word);
	
		assertEquals(expectedAbbreviation, generatedOutput);
	}
	
	@Test
	public void checkIfIdentifiesUnique() throws Exception
	{
		String[] listOfWords = {"internationalization", "localization", "accessibility", "automatically"};
		LinkedHashMap<String, ArrayList<String>> maps = testObj.createDict(listOfWords);
		
		testObj.setWordDict(maps);
		
		assertTrue(testObj.checkIfUnique("internationalization"));
		
	}
	

	@Test
	public void checkIfIdentifiesDuplicate() throws Exception
	{
		String[] listOfWords = {"internationalization", "localization", "accessibility", "automatically"};
		LinkedHashMap<String, ArrayList<String>> maps = testObj.createDict(listOfWords);
		
		testObj.setWordDict(maps);
		
		assertFalse(testObj.checkIfUnique("accessibility"));
		
	}
	

}
