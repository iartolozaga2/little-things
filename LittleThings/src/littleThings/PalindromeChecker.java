package littleThings;

import java.util.Scanner;

public class PalindromeChecker {
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		boolean done = false; 
		//This should never end (for now)
		while (!done) { 													
			System.out.println("Please write the word you want to check:");
			String word = in.nextLine();
			//calls isPalindrome() for the desired word
			if (isPalindrome(word)) { 											
				System.out.println("Thats a palindrome!");
			} else {
				System.out.println("That's not a palindrome :(");
			}
		}
		//Closes the scanner (technically never reaches this yet)
		in.close();																
	}
	
	public static boolean isPalindrome(String string) {
		//Creates a character array out of the desired string
		char[] charArray = string.toCharArray();								
		for (int k = 0; k < charArray.length; k++) {
			//Makes all the chars lower case (makes comparison easier)
			charArray[k] = Character.toLowerCase(charArray[k]);					
		}
		boolean result = true;
		if (charArray.length % 2 == 0) {
			//Compares word letter by letter for even-length words
			for (int i = 0; i < charArray.length; i++) {
				if (charArray[i] != charArray[charArray.length - i - 1]) {		
					result = false;
				}
			}
		} else {
			//Compares word letter by letter for odd-length words
			for (int j = 0; j < charArray.length - 1; j++) {
				if (charArray[j] != charArray[charArray.length - j - 1]) {	
					result = false;
				}
			}
		}
		return result;
	}
}
