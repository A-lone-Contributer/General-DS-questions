// Find maximum in an array

public class recursion {


    // function to find the max element
    public static int findMax(int[] a, int idx) {

        // if no element then return -1
        if (idx == a.length)
            return -1;

        // faith that fxn will find max from idx+1 to a.length
        int maxInSmallerArray = findMax(a, idx + 1);

        // return max at each instance of recursion
        return Math.max(maxInSmallerArray, a[idx]);
    }

    // driver code
    public static void main(String[] args) {

        int[] arr = {2, 7, 1, 8, 9, 0};
        System.out.println(findMax(arr, 0));
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
