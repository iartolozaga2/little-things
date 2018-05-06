package littleThings;

import java.util.Scanner;

public class PalindromeChecker {
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		boolean done = false; 
		while (!done) { 														//This should never end (for now)
			System.out.println("Please write the word you want to check:");
			String word = in.nextLine();
			if (isPalindrome(word)) { 											//calls isPalindrome() for the desired word
				System.out.println("Thats a palindrome!");
			} else {
				System.out.println("That's not a palindrome :(");
			}
		}
		in.close();																//Closes the scanner (technically never reaches this yet)
	}
	
	public static boolean isPalindrome(String string) {
		char[] charArray = string.toCharArray();								//Creates a character array out of the desired string
		for (int k = 0; k < charArray.length; k++) {							
			charArray[k] = Character.toLowerCase(charArray[k]);					//Makes all the chars lower case (makes comparison easier)
		}
		boolean result = true;
		if (charArray.length % 2 == 0) {
			for (int i = 0; i < charArray.length; i++) {
				if (charArray[i] != charArray[charArray.length - i - 1]) {		//Compares word letter by letter for even-length words
					result = false;
				}
			}
		} else {
			for (int j = 0; j < charArray.length - 1; j++) {
				if (charArray[j] != charArray[charArray.length - j - 1]) {		//Compares word letter by letter for odd-length words
					result = false;
				}
			}
		}
		return result;
	}
}
