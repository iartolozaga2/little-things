package littleThings;

import java.util.ArrayList;
import java.util.Collections;

public class FifteenPuzzleGameSolver {
	
	//This class depends on the FifteenPuzzleGame class
	
	public static void main (String[] args) {
		int[] board = FifteenPuzzleGame.setup();
		FifteenPuzzleGame.visualize(board);
		System.out.println("Solving...");
		//It is possible to swap between a naive strategy and a smart one (only naive for now)
		naiveSolve(board);
	}
	
	//Naive strategy, just pick a possible move and make it.
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
			Collections.shuffle(possibleMoves);
			makeMove(board,possibleMoves.get(0));
			FifteenPuzzleGame.visualize(board);
			turns++;
			if (FifteenPuzzleGame.checkDone(board)) {
				done = true;
				System.out.println("Done! It took " + turns + " turns.");
			}
		}
	}
	
	public static void makeMove(int[] board, int move) {
		int iZero = FifteenPuzzleGame.asList(board).indexOf(0);
		board[FifteenPuzzleGame.asList(board).indexOf(move)] = 0;
		board[iZero] = move;
	}
}
