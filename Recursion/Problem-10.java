// Print all the knight tour configurations

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class recursion {

    // driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int[][] chess = new int[n][n];
        printKnightsTour(chess, r, c, 1);
    }

    // function to print knights tour
    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {

        // if row and column goes negative or exceeds board length or the cell is already
        // visited then return
        if (r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] != 0) {
            return;

            // for a 5*5 board now say we are at 25th (last) cell then
        } else if (upcomingMove == chess.length * chess.length) {

            // make the last move
            chess[r][c] = upcomingMove;

            // print the configuration
            displayBoard(chess);

            // unmark the move
            chess[r][c] = 0;

            return;
        }

        // make the move and mark the cell
        chess[r][c] = upcomingMove;

        // make recursive calls for all the possible moves a knight can make
        printKnightsTour(chess, r - 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c - 1, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 2, c - 1, upcomingMove + 1);

        // unmark the cell for next row call
        chess[r][c] = 0;
    }

    // function to display the board
    public static void displayBoard(int[][] chess) {
        for (int[] ints : chess) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}

// Time Complexity : O(8^(N^2))
