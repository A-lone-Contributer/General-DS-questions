// Find the smallest nearest element to the right of each element
// in the given array

import java.util.ArrayList;
import java.util.Stack;

public class stack {

    public static ArrayList<Integer> nearestSmallerToRight(int[] arr) {

        // stack to keep track of smaller elements
        Stack<Integer> st = new Stack<>();

        // auxiliary array to store the result
        ArrayList<Integer> result = new ArrayList<>();

        // traverse through the array in reverse as we
        // want the stack to be in same traverse order as 
        // array
        for (int i = arr.length - 1; i >= 0; i--) {
            // if there are elements in the stack then check if
            // top of the stack is greater than current element
            // if yes, then it is not desirable so pop it as we
            // want only smaller element on the top
            if (!st.empty() && st.peek() >= arr[i])
                st.pop();

            // if the stack is becomes empty or is still empty the
            // there is no smaller element to the left
            if (st.empty())
                result.add(-1);

            else

                // else top is the smallest to the left
                result.add(st.peek());

            // if not conditions are met then simply push the array
            // element to the stack
            st.push(arr[i]);
        }

        return result;
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = {11, 13, 21, 3};
        ArrayList<Integer> list = nearestSmallerToRight(arr);

        // print the reverse of the result
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }

}

// Time Complexity : O(N)
// Space Complexity : O(N)
