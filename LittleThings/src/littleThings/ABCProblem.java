package littleThings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class ABCProblem {
	
	// http://rosettacode.org/wiki/ABC_Problem
	
	public static void main(String[] args) {
		System.out.println("Generating blocks...\n");
		ArrayList<Character[]> blocks = fill();
		System.out.println("These are your blocks:\n");
		printBlocks(blocks);
		Scanner in = new Scanner(System.in);
		System.out.println("\nEnter you word:");
		String word = in.nextLine();
		in.close();
		if (canBeDone(word,blocks)) {
			System.out.println("The word you entered can be made with the given blocks!");
		} else {
			System.out.println("The word you entered can't be made with the given blocks :(");
		}
	}
	
	public static ArrayList<Character[]> fill() {
		ArrayList<Character[]> result = new ArrayList<>();
		int counter = 20;
		while (counter != 0) {
			Character[] arr = new Character[2];
			Random r = new Random();
			char c1 = (char)(r.nextInt(26) + 'a');
			char c2 = (char)(r.nextInt(26) + 'a');
			arr[0] = c1;
			arr[1] = c2;
			result.add(arr);
			counter--;
		}
		HashSet<Character> alphabet = new HashSet<>();
		for (Character[] array : result) {
			for (char c : array) {
				alphabet.add(c);
			}
		}
		return (alphabet.size() == 26) ? result : fill();
	}
	
	public static boolean canBeDone (String word,ArrayList<Character[]> blocks) {
		return true; //TODO: Boolean that checks if the string word can be built with the given blocks
	}
	
	public static void printBlocks(ArrayList<Character[]> blocks) {
		for (Character[] arr : blocks) {
			System.out.println("(" + arr[0] + " " + arr[1] + ")");
		}
	}
}
 