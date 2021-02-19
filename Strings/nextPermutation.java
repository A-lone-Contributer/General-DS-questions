public class core {

    // driver code
    public static void main(String[] args) {
        System.out.println(getNextPermutation("zyxwvtu"));
        System.out.println(getNextPermutation("dkhc"));
    }


    public static String getNextPermutation(String text) {

        // next permutation
        char[] letters = text.toCharArray();

        // find the largest decreasing sequence.
        int startLongestNonInc = text.length() - 1;

        // loop back from the end of the char array, until you find
        // a spot where the preceding char is greater than the next.
        while (startLongestNonInc > 0 &&
                text.charAt(startLongestNonInc - 1) >= text.charAt(startLongestNonInc)) {
            startLongestNonInc--;
        }


        if (startLongestNonInc <= 0) {
            // then you must be at the last permutation.
            // e.g. "54321" is the last permutation of that sequence.
            // "cba", "321"
            return null;
        }

        // next we need to find a "pivot point".
        // this is a following element (to the right) that is
        // greater than the start of the largest decreasing sequence.
        int pivotSwapWith = text.length() - 1;
        while (text.charAt(pivotSwapWith) <= text.charAt(startLongestNonInc - 1)) {
            pivotSwapWith--;
        }

        // Swap the pivot with the higher element to the right
        char temp = letters[startLongestNonInc - 1];
        letters[startLongestNonInc - 1] = letters[pivotSwapWith];
        letters[pivotSwapWith] = temp;

        // Reverse the suffix sequence
        pivotSwapWith = text.length() - 1;
        while (startLongestNonInc < pivotSwapWith) {

            // another bit of swapping code.
            // pull out original
            temp = letters[startLongestNonInc];

            // assign the end to the beginning.
            letters[startLongestNonInc] = letters[pivotSwapWith];

            // assign the temp back to the other spot.
            letters[pivotSwapWith] = temp;
            startLongestNonInc++;
            pivotSwapWith--;
        }


        // remember, strings are immutable, so we need to pass
        // back a new string from the char array.
        return new String(letters);
    }
}

// Time Complexity : O(N)
// Space Complexity : O(N)
