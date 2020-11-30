// Reverse the stack using recursion

import org.jetbrains.annotations.NotNull;
import java.util.Stack;

class Misc{

    // create a stack
    Stack<Integer> st = new Stack<>();

    // utility function to insert at the top of st
    public void insert_At_bottom(int data)
    {
        st.push(data);
    }

    // Recursive function to reverse the stack
    public Stack<Integer> Reverse(@NotNull Stack<Integer> s)
    {
        // if stack is not empty
        if(!s.isEmpty())
        {
            // pop the last element
            int x = s.pop();

            // insert at the bottom of the new stack
            insert_At_bottom(x);

            // recurse
            Reverse(s);

        }

        return st;
    }

    // driver code
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Original stack");
        System.out.println(stack);

        Misc rs = new Misc();
        System.out.println("Reversed stack");
        Stack<Integer> rvs = rs.Reverse(stack);
        System.out.print(rvs);

    }
}

// Time Complexity : O(N)
// Space Complexity : O(1)
