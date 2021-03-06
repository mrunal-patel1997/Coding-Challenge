/**
 * @Author Mrunal Patel
 * @Date 2019-05-14
 * @Problem 1
 * @Description Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 */

import java.util.*;

public class solution1 {

	private static int size = 10;
	private static int[] arrNums = new int[size];
	private static int ranNumK;
	
	private static final int min = 0;
	private static final int max = 30;
	
	private static int generateRandomNum () {
		//each call generates a random number
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}
	
	private static void setK() {
		ranNumK = generateRandomNum();
		System.out.println("Given K: " + ranNumK);
	}
	
	private static void setArr() {
		for (int i = 0; i < arrNums.length; i++) {
			arrNums[i] = generateRandomNum();
		}
		if ((numUnique(arrNums)) < size) {
			setArr();
		}//make sure numbers are unique
		else {
			System.out.print("Given Array: ");
			System.out.println(java.util.Arrays.toString(arrNums));
		}
	}
	
	private static long numUnique (int[] list) {
		return Arrays.stream(list).distinct().count();
	}
	
	private static boolean checkSum (int val, int arr[]) {
		HashSet<Integer> h = new HashSet<Integer>();
		
		for (int i = 0; i < arrNums.length; i++) {
			int temp = val - arr[i];
			
			if (temp >=0 && h.contains(temp)) {
				System.out.println("TRUE");
				System.out.println("Two numbers in the array that sum to K are: " + arr[i] + ", " + temp);
				return true;
			}
			h.add(arr[i]);
		}
		System.out.println("FALSE");
		System.out.println("No two numbers in the array sum to K.");
		return false;
	}
	
	public static void main(String[] args) {
		setK();
		setArr();
		checkSum(ranNumK, arrNums);

	}

}
