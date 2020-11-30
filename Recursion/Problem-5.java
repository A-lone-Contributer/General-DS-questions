// Print all the subsets of array

public class recursion {

    // function to print subsets
    public static void printSubsets(int[] a) {
        if (a == null || a.length == 0)
            return;

        int[] buffer = new int[a.length];
        printSubsetsHelper(a, buffer, 0, 0);
    }

    public static void printSubsetsHelper(int[] a, int[] buffer, int startIndex, int bufferIndex) {

        // print the buffer till bufferIndex
        printArray(buffer, bufferIndex);

        // termination cases - buffer full
        if (bufferIndex == buffer.length)
            return;


        // if the given array ends
        if (startIndex == a.length) {
            return;
        }

        // find candidates that go into current buffer index
        for (int i = startIndex; i < a.length; i++) {

            // place item into buffer
            buffer[bufferIndex] = a[i];

            // recurse for next index in bufferIndex and next startIndex
            printSubsetsHelper(a, buffer, i + 1, bufferIndex + 1);
        }
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printSubsets(arr);
    }

    // utility function to print array
    public static void printArray(int[] a, int idx) {
        System.out.print("[");
        for (int i = 0; i < idx; i++)
            System.out.print(a[i] + ",");
        System.out.print("]"+"\n");
    }

}

// Time Complexity : O(2^n)
// Space Complexity : O(2N) [buffer allocation + recursion stack]
