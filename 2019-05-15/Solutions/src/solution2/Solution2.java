package solution2;
/**
 * @Author Mrunal Patel
 * @Date 2019-05-15
 * @Problem 2
 * @Description Given an array of integers, return a new array such that each element at index i of the new array is 
 * 				the product of all the numbers in the original array except the one at i.
 * 				Follow-up: what if you can't use division?
 */

import java.util.*;

public class Solution2 {
	
	private static final int min = 1;
	private static final int max = 7;
	private static final int sizemin = 3;
	private static final int sizemax = 5;
	private static int size; 
	
	
	private static int generateRandomNum() {
		//each call generates a random number
		Random rand = new Random();
		return rand.nextInt((sizemax - sizemin) + 1) + sizemin;
	}
	
	private static int generateRandomNumArr() {
		//each call generates a random number
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

	private static void setSize() {
		size = generateRandomNum();
	}
	
	private static int getSize() {
		return size;
	}
	
	private static void setArr(int[] arrA) {
		for (int i = 0; i < arrA.length; i++) {
			arrA[i] = generateRandomNumArr();
		}
		if ((numUnique(arrA)) < size) {
			setArr(arrA);
		}//make sure numbers are unique
		else {
			System.out.print("Given Array: ");
			printIntegerArray(arrA);
		}
	}
	
	private static void printIntegerArray (int[] arr) {
		System.out.println(java.util.Arrays.toString(arr));
	}
	
	private static long numUnique (int[] arr) {
		return Arrays.stream(arr).distinct().count();
	}
	
	private static int calProductWithoutI (int[] arr, int exclude) {
		int prod = 1;
		for (int i = 0; i<arr.length; i++) {
			if (i == exclude) {
			}
			else {
				prod = prod * arr[i];
			}
		}
		return prod;
	}
	
	
	public static void main(String[] args) {
		
		setSize();
		//System.out.println("Size is: "+ getSize());
		
		int[] arrA = new int[size];
		int[] arrB = new int[getSize()];
		setArr(arrA);
		
		for (int i = 0; i <arrB.length; i++) {
			arrB[i] = calProductWithoutI (arrA, i);
		}
		System.out.print("Resulting Array is: ");
		printIntegerArray(arrB);
	}

}
