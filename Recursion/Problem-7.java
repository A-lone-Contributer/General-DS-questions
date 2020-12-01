/*

Maze Problem: You are given a 2D array that represents a maze. It can have 2 values - 0 and 1. 1 represents a wall and
0 represents a path.

The objective is to reach the bottom right corner, i.e, A[A.length-1][A.length-1]. You start from
A[0][0]. You can move in 4 directions - up, down, left and right. Find if a path exists to the
bottom right of the maze.

*/

import java.util.Arrays;

enum State {
    UNVISITED,
    VISITING,
    NO_PATH_FOUND;
}

public class recursion {

    // main function
    public static boolean pathExists(int[][] a) {
        if (a == null || a.length == 0)
            return false;

        State[][] memo = new State[a.length][a[0].length];

        for (State[] states : memo)
            Arrays.fill(states, State.UNVISITED);

        return pathExistsHelper(a, 0, 0, memo);
    }

    // utility function to check for out of bounds
    private static boolean oob(int[][] a, int i, int j) {
        return i < 0 || i >= a.length || j < 0 || j >= a[0].length;
    }


    // A recursive utility function to solve Maze problem
    public static boolean pathExistsHelper(int[][] a, int i, int j, State[][] memo) {

        if (oob(a, i, j) || a[i][j] == 1)
            return false;

        if (i == a.length - 1 && j == a[0][a.length - 1])
            return true;

        if (memo[i][j] == State.NO_PATH_FOUND || memo[i][j] == State.VISITING)
            return false;

        memo[i][j] = State.VISITING;

        // defining the four path possibilities
        Pair[] points = {
                new Pair(i + 1, j),
                new Pair(i - 1, j),
                new Pair(i, j + 1),
                new Pair(i, j - 1)
        };

        // checking for path in all 4 directions
        for (Pair point : points) {
            if (pathExistsHelper(a, point.getFirst(), point.getSecond(), memo)) {
                return true;
            }
        }

        // backtrack
        memo[i][j] = State.NO_PATH_FOUND;

        return false;

    }

    // driver code
    public static void main(String[] args) {
        int[][] maze = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        System.out.println(pathExists(maze));
    }
}

// Time Complexity: O(2^(n^2)) [The recursion can run upperbound 2^(n^2) times]
// Space Complexity: O(n^2) [Output matrix is required so an extra space of size n*n is needed]
