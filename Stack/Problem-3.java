// Find the smallest nearest element to the left of each element
// in the given array

import java.util.ArrayList;
import java.util.Stack;

public class stack {

    public static ArrayList<Integer> nearestSmallerToLeft(int[] arr) {

        // Create an empty stack
        Stack<Integer> S = new Stack<>();

        // auxiliary array to store the result
        ArrayList<Integer> result = new ArrayList<>();

        // Traverse all array elements
        for (int j : arr) {

            // if there are elements in the stack then check if
            // top of the stack is greater than current element
            // if yes, then it is not desirable so pop it as we
            // want only smaller element on the top
            while (!S.empty() && S.peek() >= j) {
                S.pop();
            }

            // if the stack is becomes empty or is still empty the
            // there is no smaller element to the left
            if (S.empty())
                result.add(-1);
            else
                
                // else top is the smallest to the left
                result.add(S.peek());
            
            // if not conditions are met then simply push the array
            // element to the stack
            S.push(j);
        }
  
        return result;
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = {1, 3, 0, 2, 5};
        ArrayList<Integer> list = nearestSmallerToLeft(arr);
        for (int ele : list)
            System.out.print(ele+" ");
    }

}

// Time Complexity : O(N)
// Space Complexity : O(N)
