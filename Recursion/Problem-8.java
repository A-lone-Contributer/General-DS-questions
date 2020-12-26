// To find the subsets having the given target sum

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class recursion {

    // driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int target = Integer.parseInt(br.readLine());
        printTargetSumSubsets(arr, 0, "", 0, target);
    }

    // function to print target sum subsets
    public static void printTargetSumSubsets(int[] arr, int idx, String result, int sumSoFar, int target) {

        // if the current sum exceeds the target then return
        if (sumSoFar > target) {
            return;
        }

        // if the array index is not exceeded and sum so far becomes
        // equal to target simply print the result else return
        if (idx == arr.length) {
            if (sumSoFar == target) {
                System.out.println(result + " ");
            }
            return;
        }

        // consider the current element and increase result as well as sum
        printTargetSumSubsets(arr, idx + 1, result + arr[idx] + ", ", sumSoFar + arr[idx], target);

        // do not consider the current element and just increase the index
        printTargetSumSubsets(arr, idx + 1, result, sumSoFar, target);
    }

}

// Time Complexity : O(2^N)
// Space Complexity : O(2^N)
