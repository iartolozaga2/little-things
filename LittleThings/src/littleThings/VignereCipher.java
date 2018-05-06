package littleThings;

import java.util.Scanner;

public class VignereCipher {
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			System.out.println("Enter the message you want to encode:");
			String message = in.nextLine();
			System.out.println("Enter the word you want to encode the message with:");
			String key = in.nextLine();
			System.out.println("Your encoded message:\n" + vignereEncode(message,key));
			System.out.println("Your decoded message:\n" + vignereDecode(vignereEncode(message,key),key));
		}
	}
	
	public static String vignereEncode(String message, String key) {
		char[] messageArray = message.toCharArray();
		char[] keyArray = key.toCharArray();
		for (int i = 0; i < messageArray.length; i++) {
			int messageUnicode = (int) messageArray[i];
			int keyUnicode = (int) keyArray[i%(keyArray.length)];
			messageArray[i] = (char) (messageUnicode + keyUnicode);
		}
		String result = new String (messageArray);
		return result;
	}
	
	public static String vignereDecode(String message, String key) {
		char[] messageArray = message.toCharArray();
		char[] keyArray = key.toCharArray();
		for (int i = 0; i < messageArray.length; i++) {
			int messageUnicode = (int) messageArray[i];
			int keyUnicode = (int) keyArray[i%(keyArray.length)];
			messageArray[i] = (char) (messageUnicode - keyUnicode);
		}
		String result = new String (messageArray);
		return result;
	}
}
