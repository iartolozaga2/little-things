package littleThings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FifteenPuzzleGame {

	//Plays the game
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		boolean done = false;
		int[] board = setup();
		System.out.println("INITIAL BOARD:\n" + Arrays.toString(board));
		System.out.println("The 0 represents the empty space");
		while (!done) {
			System.out.println("What number do you want to move?");
			int move = in.nextInt();
			if (validMove(board,Arrays.asList(board).indexOf(move),Arrays.asList(board).indexOf(0))) {
				board[Arrays.asList(board).indexOf(0)] = move;
				board[Arrays.asList(board).indexOf(move)] = 0;
				if (checkDone(board)) {
					done = true;
				}
			} else {
				System.out.println("Invalid move, you can ony move numbers that are adjacent to the 0.");
			}
		}
		if (done) {
			System.out.println("Congrats! You completed the puzzle!");
			in.close();
		}
	}
	
	//Sets the board up in a random way (using Collections.shuffle())
	public static int[] setup() {
		int[] result = new int[16];
		int counter = 0;
		for (int i = 0; i < 16; i++) {
			result[i] = counter;
			counter++;
		}
		//Converts to ArrayList<Integer>, shuffles, and then turns back into int[]
		//Can probably be done in an easier way
		List<Integer> list = Arrays.stream(result).boxed().collect(Collectors.toList());
		Collections.shuffle(list);
		int[] arr = list.stream().mapToInt(i -> i).toArray();
		if (checkDone(arr)) {
			return setup();
		} else {
			return arr;
		}
	}
	
	//Checks whether a move is valid or not
	//I felt physical pain while writing this
	//99% sure there's a more efficient way to do this
	public static boolean validMove(int[] board, int potential, int zero) {
		switch (Arrays.asList(board).indexOf(potential)) {
			case 0: return (Arrays.asList(board).indexOf(0) == 1 || Arrays.asList(board).indexOf(0) == 4);
			case 1: return (Arrays.asList(board).indexOf(0) == 0 || Arrays.asList(board).indexOf(0) == 5 || Arrays.asList(board).indexOf(0) == 2);
			case 2: return (Arrays.asList(board).indexOf(0) == 1 || Arrays.asList(board).indexOf(0) == 6 || Arrays.asList(board).indexOf(0) == 3);
			case 3: return (Arrays.asList(board).indexOf(0) == 2 || Arrays.asList(board).indexOf(0) == 7);
			case 4: return (Arrays.asList(board).indexOf(0) == 0 || Arrays.asList(board).indexOf(0) == 5 || Arrays.asList(board).indexOf(0) == 8);
			case 5: return (Arrays.asList(board).indexOf(0) == 4 || Arrays.asList(board).indexOf(0) == 6 || Arrays.asList(board).indexOf(0) == 1 || Arrays.asList(board).indexOf(0) == 9);
			case 6: return (Arrays.asList(board).indexOf(0) == 5 || Arrays.asList(board).indexOf(0) == 7 || Arrays.asList(board).indexOf(0) == 2 || Arrays.asList(board).indexOf(0) == 10);
			case 7: return (Arrays.asList(board).indexOf(0) == 3 || Arrays.asList(board).indexOf(0) == 6 || Arrays.asList(board).indexOf(0) == 11);
			case 8: return (Arrays.asList(board).indexOf(0) == 4 || Arrays.asList(board).indexOf(0) == 9 || Arrays.asList(board).indexOf(0) == 12);
			case 9: return (Arrays.asList(board).indexOf(0) == 5 || Arrays.asList(board).indexOf(0) == 13 || Arrays.asList(board).indexOf(0) == 8 || Arrays.asList(board).indexOf(0) == 10);
			case 10: return (Arrays.asList(board).indexOf(0) == 6 || Arrays.asList(board).indexOf(0) == 14 || Arrays.asList(board).indexOf(0) == 9 || Arrays.asList(board).indexOf(0) == 11);
			case 11: return (Arrays.asList(board).indexOf(0) == 7 || Arrays.asList(board).indexOf(0) == 10 || Arrays.asList(board).indexOf(0) == 15);
			case 12: return (Arrays.asList(board).indexOf(0) == 8 || Arrays.asList(board).indexOf(0) == 13);
			case 13: return (Arrays.asList(board).indexOf(0) == 9 || Arrays.asList(board).indexOf(0) == 12 || Arrays.asList(board).indexOf(0) == 14);
			case 14: return (Arrays.asList(board).indexOf(0) == 10 || Arrays.asList(board).indexOf(0) == 13 || Arrays.asList(board).indexOf(0) == 15);
			case 15: return (Arrays.asList(board).indexOf(0) == 11 || Arrays.asList(board).indexOf(0) == 14);
			default: return false;
		}
	}
	
	//Returns true if the player has completed the puzzle
	public static boolean checkDone(int[] board) {
		//Creates a solved board
		int[] solvedBoard = new int[16];
		int counter = 1;
		for (int i = 0; i < 15; i++) {
			solvedBoard[i] = counter;
			counter++;
		}
		solvedBoard[15] = 0;
		//Compares the solved board with the potential one tile by tile
		for (int j = 0; j < 16; j++) {
			if (solvedBoard[j] != board[j]) {
				return false;
			}
		}
		return true;
	}
}
