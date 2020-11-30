// Sort Stack using Recursion

import java.util.ListIterator;
import java.util.Stack;

class Misc {

    // Function to insert in a sorted manner
    static void sortedInsert(Stack<Integer> stack, int data) {

        // Base case:
        // If the stack is empty and the incoming data is less than the top
        // the push the data
        if (stack.isEmpty() || data < stack.peek()) {
            stack.push(data);
            return;
        }

        // pop and store the top element
        int temp = stack.pop();

        // Do recursion for thr rest of the stack
        sortedInsert(stack, data);

        // now push the stored element
        stack.push(temp);
    }


    // function to sort the stack
    static void sort(Stack<Integer> s) {

        // is the stack is not empty
        if (!s.isEmpty()) {

            // pop and store the top element
            int x = s.pop();

            // sort the rest of the stack
            sort(s);

            // insert the elements in the sorted way
            sortedInsert(s, x);

        }
    }

    // Utility Method to print contents of stack
    static void printStack(Stack<Integer> s) {
        ListIterator<Integer> lt = s.listIterator();

        // forwarding
        while (lt.hasNext())
            lt.next();

        // printing from top to bottom
        while (lt.hasPrevious())
            System.out.print(lt.previous() + " ");
    }

    // Driver code
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.println("Stack elements before sorting: ");
        printStack(s);

        sort(s);

        System.out.println(" \n\nStack elements after sorting:");
        printStack(s);

    }

}

// Time Complexity: O(N^2)
// Space Complexity : O(1)
