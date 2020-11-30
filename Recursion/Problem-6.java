// Print permutations of length X

import java.util.Arrays;

public class recursion {

    // function to print permutations of length x
    public static void printPerms(int[] a, int x) {
        if (a == null || a.length == 0 || x > a.length)
            return;
        
        int[] buffer = new int[x];
        boolean[] isInBuffer = new boolean[a.length];
        printPermsHelper(a, buffer, 0, isInBuffer);
    }
    
    
    public static void printPermsHelper(int[] a, int[] buffer, int bufferIndex, boolean[] isInBuffer) {

        // termination case - buffer full
        if (bufferIndex == buffer.length) {
            System.out.println(Arrays.toString(buffer));
            return;
        }

        // find candidates that go into current buffer index
        for (int i = 0; i < a.length; i++) {

            if (!isInBuffer[i]) {

                // place candidate into buffer index
                buffer[bufferIndex] = a[i];
                isInBuffer[i] = true;

                // recurse to next buffer index
                printPermsHelper(a, buffer, bufferIndex + 1, isInBuffer);
                isInBuffer[i] = false;
            }
        }
    }

    // driver code
    public static void main(String[] args) {
        int[] org = {1, 2, 3, 4, 5};
        printPerms(org, 3);
    }

}

// Time Complexity : O(n!/(n-X-1)!)
// Space Complexity : O(2N) [Buffer allocation + Recursion stack]
