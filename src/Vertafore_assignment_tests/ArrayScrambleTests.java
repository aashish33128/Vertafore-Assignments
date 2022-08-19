package Vertafore_assignment_tests;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import Vertafore_Assignments.ArrayScramble;

public class ArrayScrambleTests {
	
	ArrayScramble testObj = new ArrayScramble();
	
	@Test
	public void valuesAreRandom()
	{
		int[] inputArray = {1,2,3,4,5};
		int[] outputArray1 = testObj.scramble_Array(inputArray);
		int[] outputArray2 = testObj.scramble_Array(inputArray);
		
		
		
		//Check if  two output Arrays are different with random order
		
		assert(!Arrays.equals(outputArray1, outputArray2));
		
	}
	
	@Test
	public void ArrayRemainsUnchanged()
	{
		int[] inputArray = {1,2,3,4,5};
		int[] outputArray1 = testObj.scramble_Array(inputArray);

		
		
		//Check if  two output Arrays have the same elements
		Arrays.sort(outputArray1);
		
		
		assert(Arrays.equals(inputArray, outputArray1));
		
	}

}
