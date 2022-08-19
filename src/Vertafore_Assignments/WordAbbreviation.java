package Vertafore_Assignments;

import java.util.ArrayList;
import java.util.LinkedHashMap;


/**
 * 
 * @author aashishdhungana
 * Question 2 (2, 3, build off each other)

/*

* Consider the following style of abbreviation:

*   (first letter) + (count of removed letters) + (last letter)

* For example:

*   "internationalization" -> "i18n"

*   "localization" -> "l10n"

* Write a function that given any word returns its abbreviation.

Question 3

/*

* Such abbreviations are not always unique, for example:

*   "accessibility" -> "a11y"

*   "automatically" -> "a11y"

* Given a dictionary (a list of words), write a function that takes a word and

* returns true if the abbreviation of the word is unique in the dictionary.

*

* For example, given a dictionary with the 4 words above:

*   "internationalization" -> true

*   "localization" -> true

*   "accessibility" -> false

*   "automatically" -> false
 *
 */

public class WordAbbreviation {
	
	LinkedHashMap<String, ArrayList<String>> maps = null;

	
	
	public void setWordDict(LinkedHashMap<String, ArrayList<String>> maps)
	{
		this.maps = maps;
	}
	
	/**
	 * 
	 * @param inputString
	 * @return the word abbreviation based on the requirements given in the question
	 */
	public String getWordAbbreviation(String inputString)
	{
		//No word abbreviation for string with length less than 2
		if(inputString.length()<=2)
			return inputString;
		
		char[] wordBytes = inputString.toCharArray();
		StringBuilder outputString = new StringBuilder();
		char firstByte = wordBytes[0];
		char lastByte = wordBytes[inputString.length()-1];
		int removedLetters = inputString.length()-2;
		
		outputString.append(firstByte);
		outputString.append(String.valueOf(removedLetters));
		outputString.append(lastByte);
		return outputString.toString();
	}
	
	
	public LinkedHashMap<String, ArrayList<String>> createDict(String[] words)
	{
		LinkedHashMap<String, ArrayList<String>> dict = new LinkedHashMap<>();
		for(String word: words)
		{
			String abbreviation = getWordAbbreviation(word);
		
			if(!dict.containsKey(abbreviation))
			{
				ArrayList<String> wordList = new ArrayList<>();
				wordList.add(word);
				dict.put(abbreviation, wordList);
			
	
			}
			else
			{
				dict.get(abbreviation).add(word);
			}
		 }
		
		return dict;
		
	}
	
	/**
	 * 
	 * @param word - Input Word
	 * @return True if the word abbreviation is unique in the dictionary other wise false
	 * @throws Exception
	 * Checks if Dictionary is initialized before this method is executed
	 */
	public boolean checkIfUnique(String word) throws Exception
	{
		
		if(this.maps==null)
		{
			throw new Exception("Dictionary is not initialized");
		}
		
		String abbreviation = getWordAbbreviation(word);
		ArrayList<String> values = this.maps.get(abbreviation);
		
		if(values.isEmpty())
		{
			throw new Exception("New word Detected. Word is not in the dictionary");
		}
		
		if(values.size()==1) return true;		
		return false;
	}
	
	
	public static void main(String[] args)
	{
		WordAbbreviation obj = new WordAbbreviation();
		
		String inputString = "localization";
		String outputString = obj.getWordAbbreviation(inputString);
		System.out.println("Word Abbreviation for  " + inputString + " is " + outputString );
		
		
		//Part 2 of the question
		
		//Checking Unique Abbreviation
		
		String[] listOfWords = {"internationalization", "localization", "accessibility", "automatically"};
		
		//Create Dict method needs to be executed before calling the checkUnique function
		
		LinkedHashMap<String, ArrayList<String>> maps = obj.createDict(listOfWords);
		
		//Set a global dictionary
		obj.setWordDict(maps);
		
		//Check and print if the word abbreviation in the dict is unique
		for(String word: listOfWords)
		{
			try {
				System.out.println(word + "->" + obj.checkIfUnique(word));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Exception occurred.Please check your input " + e.toString());
			}
		}
		
		
	}

}
