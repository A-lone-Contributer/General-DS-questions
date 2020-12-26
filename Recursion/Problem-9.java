// Print the configurations to place N Queens on a chess board

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class recursion {

    // driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        printNQueens(chess, "", 0);
    }

    // function to print N Queens Configuration
    public static void printNQueens(int[][] chess, String queenSoFar, int row) {

        // if the row value is equal to board length just print the
        // configuration
        if (row == chess.length) {
            System.out.println(queenSoFar + ".");
            return;
        }

        // traverse through the columns
        for (int col = 0; col < chess.length; col++) {

            // check if the the board cell isn't visited yet and the
            // queen is safe to place
            if (chess[row][col] == 0 && isQueenSafe(chess, row, col)) {

                // mark that cell to not visit it again while backtracking
                chess[row][col] = 1;

                // recurse and print the row and col values
                printNQueens(chess, queenSoFar + row + "-" + col + ", ", row + 1);

                // unmark the cell for the next row recursion call
                chess[row][col] = 0;
            }
        }
    }

    // code to check if the queen is safe to place
    public static boolean isQueenSafe(int[][] chess, int row, int col) {

        /* We cannot place queens in upward and left direction, left and right diagonals */

        // check for left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        // check for upward direction
        for (int i = row - 1; i >= 0; i--) {
            if (chess[i][col] == 1) {
                return false;
            }
        }

        // check for right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }

        // check for left direction
        for (int j = col - 1; j >= 0; j--) {
            if (chess[row][j] == 1) {
                return false;
            }
        }

        return true;
    }
}

// Time Complexity : O(n!)
// Space Complexity : O(n)
