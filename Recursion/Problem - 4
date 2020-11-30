// Print all the combinations of length X


/*

ALGORITHM
---------

We use a buffer of size X with a recursive function "printCombosHelper".
In any recursive call to printCombosHelper(), the buffer is filled up to a certain index i-1, and
the task for the function call is to fill index i. If i is greater than the size of the buffer,
then the buffer is full, and we print its contents.
Otherwise, we find the candidates from the input array that can go into index i. We place each
candidate into index i and then call printCombosHelper() for i+1.

*/

public class recursion {

    public static void printCombos(int[] a, int x) {
        if (a == null || a.length == 0 || x > a.length)
            return;

        int[] buffer = new int[x];
        printCombosHelper(a, buffer, 0, 0);
    }

    public static void printCombosHelper(int[] a, int[] buffer, int startIndex, int bufferIndex) {

        // termination cases - buffer full
        if (bufferIndex == buffer.length) {
            printArray(buffer);
            return;
        }

        // if the given array ends
        if (startIndex == a.length) {
            return;
        }

        // find candidates that go into current buffer index
        for (int i = startIndex; i < a.length; i++) {

            // place item into buffer
            buffer[bufferIndex] = a[i];

            // recurse for next index in bufferIndex and next startIndex
            printCombosHelper(a, buffer, i + 1, bufferIndex + 1);
        }
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int x = 3;
        printCombos(arr, x);
    }

    public static void printArray(int[] a) {
        for (int num : a)
            System.out.print(num + " ");

        System.out.println();
    }

}

// Time Complexity : O(n!)
// Space Complexity : O(2X) [buffer allocation + recursion stack]
