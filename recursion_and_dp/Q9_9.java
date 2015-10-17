package recursion_and_dp;

import java.util.ArrayList;

// print all ways of arranging eight queens on an 8*8 chess board
// so that none of them share the same row, column or diagonal.

// solution 1: placing n-1 queens on an n-by-(n-1) chessboard
// backtracking
public class Q9_9 {
	
	static int GRID_SIZE = 8;
	
	// board: columsForRow[row number] = col number
	public static void placeQueens(int row, Integer[] board, ArrayList<Integer[]> boards){
		if (row == GRID_SIZE) {
			boards.add(board.clone());
			// or printboard here
		}
		for(int col = 0; col < GRID_SIZE; col++){
			if(checkValid(board, row, col)){
				board[row] = col;
				placeQueens(row + 1, board, boards);
			}
		}
	}
	
	
	
	public static boolean checkValid(Integer[] columns, int row1, int column1) {
		for (int row2 = 0; row2 < row1; row2++) {
			int column2 = columns[row2];
			/* Check if (row2, column2) invalidates (row1, column1) as a queen spot. */
			
			/* Check if rows have a queen in the same column */
			if (column1 == column2) { 
				return false;
			}
			
			/* Check diagonals: if the distance between the columns equals the distance
			 * between the rows, then they're in the same diagonal.
			 */
			int columnDistance = Math.abs(column2 - column1); 
			int rowDistance = row1 - row2; // row1 > row2, so no need to use absolute value
		    if (columnDistance == rowDistance) {
		    	return false;
		    }
		}
		return true;
	}

	
	
	public static void clear(Integer[] board){
		for(int i = 0; i < GRID_SIZE; i++){
			board[i] = -1;
		}
	}
	
	
	
	// print
	public static void printBoards(ArrayList<Integer[]> boards){
		for(int i = 0; i < boards.size(); i++){
			Integer[] board = boards.get(i);
			printBoard(board);
		}
	}
	
	public static void printBoard(Integer[] board) {
        drawLine();
        for(int i = 0; i < GRID_SIZE; i++){
			System.out.print("|");
			for (int j = 0; j < GRID_SIZE; j++){
			    if (board[i] == j) {
			    	System.out.print("Q|");
			    } else {
			    	System.out.print(" |");
			    }
			}
            System.out.print("\n");
            drawLine();
		}
		System.out.println("");
	}
	
    private static void drawLine() {
        StringBuilder line = new StringBuilder();
        for (int i=0;i<GRID_SIZE*2+1;i++)
            line.append('-');
        System.out.println(line.toString());
    }
	
	// main
	public static void main(String[] args){
		ArrayList<Integer[]> boards = new ArrayList<Integer[]>();
		Integer[] board = new Integer[GRID_SIZE];
		clear(board);
		placeQueens(0, board, boards);
		printBoards(boards);
		System.out.println(boards.size());
	}
	
}
