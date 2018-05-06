package littleThings;

import java.util.Scanner;

public class CaesarCipher {
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			System.out.println("Write the message you want to encode:");
			String message = in.nextLine();
			System.out.println("Enter the number of shifts you want for your encoding:");
			int shift = in.nextInt();
			System.out.println("Your encoded message:\n" + caesarEncode(message,shift));
			System.out.println("Your decoded message:\n" + caesarDecode(caesarEncode(message,shift),shift));
			
		}
		in.close();
	}
	
	public static String caesarEncode(String str, int shift) {
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			//Gets the Unicode value of a certain char
			int unicode = (int) charArray[i];
			//Adds the shift amount to the unicode int and replaces the value in the array
			charArray[i] = (char)(unicode + shift);
		}
		String result = new String(charArray);
		return result;
	}
	
	public static String caesarDecode(String str, int shift) {
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			//Gets the Unicode value of a certain char
			int unicode = (int) charArray[i];
			//Subtracts the shift amount to the unicode int and replaces the value in the array
			charArray[i] = (char)(unicode - shift);
		}
		String result = new String(charArray);
		return result;
	}
}
