package littleThings;

import java.util.Scanner;

public class PalindromeChecker {
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			System.out.println("Please write the word you want to check:");
			String word = in.nextLine();
			if (isPalindrome(word)) {
				System.out.println("Thats a palindrome!");
			} else {
				System.out.println("That's not a palindrome :(");
			}
		}
		in.close();		
	}
	
	public static boolean isPalindrome(String string) {
		char[] charArray = string.toCharArray();
		for (int k = 0; k < charArray.length; k++) {
			charArray[k] = Character.toLowerCase(charArray[k]);
		}
		boolean result = true;
		if (charArray.length % 2 == 0) {
			for (int i = 0; i < charArray.length; i++) {
				if (charArray[i] != charArray[charArray.length - i - 1]) {
					result = false;
				}
			}
		} else {
			for (int j = 0; j < charArray.length - 1; j++) {
				if (charArray[j] != charArray[charArray.length - j - 1]) {
					result = false;
				}
			}
		}
		return result;
	}
}
