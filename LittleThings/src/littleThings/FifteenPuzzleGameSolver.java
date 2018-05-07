package littleThings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class FifteenPuzzleGameSolver {

	// This class depends on the FifteenPuzzleGame class

	public static void main(String[] args) {
		int[] board = FifteenPuzzleGame.setup();
		FifteenPuzzleGame.visualize(board);
		System.out.println("\n\nSolving...");
		// Change between smartSolve and naiveSolve here
		smartSolve(board);
	}

	// Naive strategy, just pick a possible move and make it. Very bruteforce-y.
	// Expected estimated time of completion is ~ 33k years (not feasible).
	public static void naiveSolve(int[] board) {
		ArrayList<Integer> possibleMoves = new ArrayList<>();
		int turns = 0;
		boolean done = false;
		while (!done) {
			for (int i = 0; i < 16; i++) {
				if (FifteenPuzzleGame.validMove(board, i, FifteenPuzzleGame.asList(board).indexOf(0))) {
					possibleMoves.add(i);
				}
			}
			// Gets a random value from possibleMoves and makes that move
			Collections.shuffle(possibleMoves);
			makeMove(board, possibleMoves.get(0));
			FifteenPuzzleGame.visualize(board);
			turns++;
			if (FifteenPuzzleGame.checkDone(board)) {
				done = true;
				System.out.println("Done! It took " + turns + " turns.");
			}
		}
	}

	// Smart solver, essentially like naive but it tries to leave tiles which are
	// already correctly placed alone if possible
	// Not functional yet
			
	public static void smartSolve(int[] board) {
		int turns = 0;
		boolean done = false;
		while (!done) {
			// Creates an ArrayList called completed with the numbers that are in their
			// correct position already
			ArrayList<Integer> completed = new ArrayList<>();
			for (int p = 0; p < board.length; p++) {
				if (FifteenPuzzleGame.asList(board).indexOf(p + 1) == board[p]) {
					completed.add(board[p]);
				}
			}
			// Creates an ArrayList called possibleMove with all the possible moves in a
			// certain moment
			ArrayList<Integer> possibleMoves = new ArrayList<>();
			for (int i = 0; i < 16; i++) {
				if (FifteenPuzzleGame.validMove(board, i, FifteenPuzzleGame.asList(board).indexOf(0))) {
					possibleMoves.add(i);
				}
			}
			// Creates a copy of possibleMoves called repeated and eliminates the elements
			// in it which are also in completed
			ArrayList<Integer> repeated = new ArrayList<>();
			repeated = possibleMoves;
			for (Iterator<Integer> it = possibleMoves.iterator(); it.hasNext();) {
				int j = it.next();
				if (possibleMoves.contains(j) && completed.contains(j)) {
					it.remove();
				}
			}

			// If all the potential moves are in completed, executes a random move
			// Else, it executes a random move from the non-completed ones
			Collections.shuffle(possibleMoves);
			if (repeated.size() == 0) {
				makeMove(board, possibleMoves.get(0));
			} else {
				Collections.shuffle(repeated);
				makeMove(board, repeated.get(0));
			}
			FifteenPuzzleGame.visualize(board);
			System.out.println("\n");
			turns++;
			// Checks if the board is solved
			if (FifteenPuzzleGame.checkDone(board)) {
				done = true;
				System.out.println("Done! It took " + turns + " turns.");
			}
			// Clears all ArrayLists for the next iteration
			possibleMoves.clear();
			completed.clear();
			repeated.clear();
		}
	}

	public static void makeMove(int[] board, int move) {
		int iZero = FifteenPuzzleGame.asList(board).indexOf(0);
		board[FifteenPuzzleGame.asList(board).indexOf(move)] = 0;
		board[iZero] = move;
	}
}
