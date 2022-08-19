package Vertafore_Assignments;

import java.util.ArrayList;

/**
 * 
 * @author aashishdhungana
 * Write an application that satisfies the following:

•          Small application

•          Given a fully sorted array (ascending or descending), write a method to scramble the values

e.g. (7, 13, 13, 18, 29, 33)

•          Write the code with useability, debugging, and testing in mind.
 *
 */

public class ArrayScramble {
	
	/**
	 * 
	 * @param inputArray
	 * @return a scrambled copy of the input Array
	 */
	public int[] scramble_Array(int[] inputArray)
	{
		
		if(inputArray==null)
			return null;
		
		//Array with length 1 cannot be scrambled
		if(inputArray.length==1)
			return inputArray;
		
		int[] output = new int[inputArray.length];
		ArrayList<Integer> visitedIndex = new ArrayList<>();
		
		int numItems = inputArray.length;
		int i=0;
	
		while(i<numItems)
		{
			int rIndex = (int)(Math.random() * ((numItems - 1) +1));
			
			//Make sure all random index are new
			if(!visitedIndex.contains(rIndex))
			{
				output[i] = inputArray[rIndex];
				visitedIndex.add(rIndex);
				i++;
			}
			
		}
		
		
		
		return output;
	}
	
	public static void main(String[] args)
	{
		ArrayScramble obj = new ArrayScramble();
		
		//Set up your input array here
		int[] inputArray = {7,13,13,18,29,33};
		
		int[] outputArray = obj.scramble_Array(inputArray);
		System.out.println("Scrambled Array is " );
		for(int i=0;i<outputArray.length;i++)
		{
			System.out.println(outputArray[i]+",");
		}
	}

}
