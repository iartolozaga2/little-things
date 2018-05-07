package littleThings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FifteenPuzzleGame {

	// Plays the game
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean done = false;
		int[] board = setup();
		System.out.println("INITIAL BOARD:\n");
		visualize(board);
		System.out.println("\n\nThe 0 represents the empty space");
		while (!done) {
			visualize(board);
			System.out.println("\n\nWhat number do you want to move?");
			int move = in.nextInt();
			//Checks if the selected tile is a valid one
			if (move > 15 || move < 1) {
				System.out.println("That number does not exist!");
				continue;
			}
			//Moves a valid tile to the empty one
			if (validMove(board, asList(board).indexOf(move), asList(board).indexOf(0))) {
				int iZero = asList(board).indexOf(0);
				board[asList(board).indexOf(move)] = 0;
				board[iZero] = move;
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

	//Converts a given integer arrat to a List<Integer>
	private static List<Integer> asList(int[] board) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			list.add(board[i]);
		}
		return list;
	}

	// Sets the board up in a random way (using Collections.shuffle())
	public static int[] setup() {
		int[] result = new int[16];
		int counter = 0;
		for (int i = 0; i < 16; i++) {
			result[i] = counter;
			counter++;
		}
		// Converts to ArrayList<Integer>, shuffles, and then turns back into int[]
		// Can probably be done in an easier way
		List<Integer> list = Arrays.stream(result).boxed().collect(Collectors.toList());
		Collections.shuffle(list);
		int[] arr = list.stream().mapToInt(i -> i).toArray();
		if (checkDone(arr)) {
			return setup();
		} else {
			return arr;
		}
	}

	// Checks whether a move is valid or not (i.e. if the desired number is next to
	// zero)
	public static boolean validMove(int[] board, int potential, int zero) {

		int potX = potential % 4;
		int potY = (potential - potX) / 4;

		int zeroX = zero % 4;
		int zeroY = (zero - zeroX) / 4;

		int dx = (potX - zeroX) * (potX - zeroX);
		int dy = (potY - zeroY) * (potY - zeroY);

		return (dx == 1 || dy == 1) && !(dx == 1 && dy == 1);
	}

	// Returns true if the player has completed the puzzle
	public static boolean checkDone(int[] board) {
		// Creates a solved board
		int[] solvedBoard = new int[16];
		int counter = 1;
		for (int i = 0; i < 15; i++) {
			solvedBoard[i] = counter;
			counter++;
		}
		solvedBoard[15] = 0;
		// Compares the solved board with the potential one tile by tile
		for (int j = 0; j < 16; j++) {
			if (solvedBoard[j] != board[j]) {
				return false;
			}
		}
		return true;
	}

	//Prints a visualization of the board to the console
	public static void visualize(int[] board) {
		for (int i = 0; i < board.length; i++) {
			if (i % 4 == 0) {
				if (board[i] / 10 == 0) {
					System.out.print("\n" + "| " + board[i] + "  | ");
				} else {
					System.out.print("\n" + "| " + board[i] + " | ");
				}
			} else {
				if (board[i] / 10 == 0) {
					System.out.print(board[i] + "  | ");
				} else {
					System.out.print(board[i] + " | ");
				}
			}
		}
	}
}
