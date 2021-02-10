// Find out the value of x*y

/*

Approach:

The algorithm taught in grade-school for decimal multiplication does not use repeated addition—it uses shift and add to
achieve a much better time complexity. We can do the same with binary numbers —to multiply x and y we initialize the result
to 0 and iterate through the bits of x,adding 2^k*y to the result if the kth bit of x is 1. 

The value 2^k*y can be computed by left-shifting y by k. Since we cannot use add directly, we must implement it. 
We apply the grade-school algorithm for addition to the binary case, i.e., compute the sum bit-by-bit, and "rippling" 
the carry along.

 */

public class core {

    // function to multiply x and y
    public static long multiply(long x, long y) {
        long sum = 0;
        while (x != 0) {
            // Examines each bit of x.
            if ((x & 1) != 0)
                sum = add(sum, y);
            x >>>= 1;
            y <<= 1;

        }
        return sum;
    }


    // utility function to perform addition
    private static long add(long a, long b) {
        long sum = 0, carryIn = 0, k = 1, tempA = a, tempB = b;
        while (tempA != 0 || tempB != 0) {
            long ak = a & k, bk = b & k;
            long carryout = (ak & bk) | (ak & carryIn) | (bk & carryIn);
            sum |= (ak ^ bk ^ carryIn);
            carryIn = carryout << 1;
            k <<= 1;
            tempA >>>= 1;
            tempB >>>= 1;
        }
        return sum | carryIn;
    }

    // driver code
    public static void main(String[] args) {
        System.out.println(multiply(5, 4));
    }
}

// Time Complexity : O(n^2)
// Space Complexity : O(1)
