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
		char[] charArray = string.toCharArray();
		char[] inverse = new char[charArray.length];
		for (int k = 0; k < charArray.length; k++) {
			//Makes all the chars lower case (makes comparison easier)
			charArray[k] = Character.toLowerCase(charArray[k]);					
		}
		//Fills in a new array inversely to get the inverted version of the word
		for (int i = 0; i < charArray.length; i++) {
			inverse[i] = charArray[charArray.length - 1 - i];
		}
		//Checks whether the word is still the same even when it is backwards
		for (int j = 0; j < charArray.length; j++) {
			if (charArray[j] != inverse[j]) {
				return false;
			}
		}
		return true;
	}
}
