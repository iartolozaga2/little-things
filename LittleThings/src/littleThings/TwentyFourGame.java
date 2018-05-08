package littleThings;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TwentyFourGame {

	public static void main(String[] args) {
		System.out.println("Welcome to the 24 Game! \n\nThese are your numbers:\n");
		int[] numbers = getFourNumbers();
		boolean done = false;
		while (!done) {
			Scanner in = new Scanner(System.in);
			System.out.println("\nEnter your answer:");
			String answer = in.nextLine();
			if (correctAnswer(numbers, answer)) {
				System.out.println("Nice! Your answer is correct!");
				in.close();
				done = true;
			} else {
				System.out.println("Sorry, that's not a correct answer, try again!");
			}
		}
	}

	public static int[] getFourNumbers() {
		Random rand = new Random();
		int first = rand.nextInt(9) + 1;
		int second = rand.nextInt(9) + 1;
		int third = rand.nextInt(9) + 1;
		int fourth = rand.nextInt(9) + 1;
		System.out.println(first + ", " + second + ", " + third + ", " + fourth);
		int[] result = new int[4];
		result[0] = first;
		result[1] = second;
		result[2] = third;
		result[3] = fourth;
		return result;
	}

	public static boolean correctAnswer(int[] numbers, String answer) {
		char[] answerArr = answer.toCharArray();
		if (answerArr.length == 7) {
			if (Arrays.asList(numbers).contains(Character.getNumericValue(answerArr[0])) && Arrays.asList(numbers).contains(Character.getNumericValue(answerArr[2])) 
					&& Arrays.asList(numbers).contains(Character.getNumericValue(answerArr[4])) && Arrays.asList(numbers).contains(Character.getNumericValue(answerArr[6]))) {
				for (int i = 0; i <= 4; i++) {
					if (Character.isDigit(answerArr[i])) {
						//The first and third elements here should be numbers and the middle one a sign
						//TODO: Method that returns the solved operation
						parseOperation(answerArr[i],answerArr[i+1],answerArr[i+2]);
					}
				}
			}
		}
		return false;
	}
	
	public static int parseOperation(char first, char sign, char second) {
		return 0; //TODO
	}
	
	
}
