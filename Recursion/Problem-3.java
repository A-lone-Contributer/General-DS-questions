// Find the last index of key in an array

public class recursion {

    // function to find the first index of given element
    public static int findFirstIndex(int[] a, int idx, int key) {

        // if we reach the end and element is not found, return -1
        if (idx == a.length)
            return -1;

        // faith that this fxn will return max of idx+1 to a.length
        int ans = findFirstIndex(a, idx + 1, key);

        // if key is in idx+1 to a.length
        if (ans != -1)
            return ans;

        // if key is the idx element i.e 0th index
        else if (a[idx] == key)
            return idx;

        // not found anywhere
        else return -1;

    }

    // driver code
    public static void main(String[] args) {
        int[] arr = {2, 7, 1, 4, 8, 9, 7, 4, 0};
        int key = 4;
        System.out.println(findFirstIndex(arr, 0, key));
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
