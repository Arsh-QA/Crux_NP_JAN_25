package stringAssignment;

import java.util.Scanner;

public class StringsMaxFrequencyCharacter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(maxFrequence(s));
		sc.close();
	}

	public static char maxFrequence(String s) {
		char[] charArray = s.toCharArray();
		int[] arr = new int[128];
		for (int i = 0; i < charArray.length; i++) {
			arr[charArray[i] - 'A']++;
		}
		int max = Integer.MIN_VALUE;
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				j = i;
			}
		}
		char c = (char) (j + 'A');
		return c;
	}
	
	public static char maxFrequency(String s) {
	    int[] arr = new int[128]; // Cover all ASCII characters

	    // Count frequency of each character
	    for (char c : s.toCharArray()) {
	        arr[c]++; // Directly use character as index
	    }

	    // Find max occurring character
	    int max = Integer.MIN_VALUE;
	    char maxChar = ' ';
	    for (int i = 0; i < arr.length; i++) {
	        if (arr[i] > max) {
	            max = arr[i];
	            maxChar = (char) i; // Convert index back to char
	        }
	    }
	    return maxChar;
	}

}