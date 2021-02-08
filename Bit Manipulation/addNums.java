// Add two numbers without using bitwise operators

class core
{
    static int Add(int x, int y)
    {
        // Iterate till there is no carry
        while (y != 0)
        {
            // carry now contains common
            // set bits of x and y
            int carry = x & y;

            // Sum of bits of x and
            // y where at least one
            // of the bits is not set
            x = x ^ y;

            // Carry is shifted by
            // one so that adding it
            // to x gives the required sum
            y = carry << 1;
        }
        return x;
    }

    // Driver code
    public static void main(String[] arg)
    {
        System.out.println(Add(15, 32));
    }
}

// Time Complexity : O(num of bits in y)
// Space Complexity : O(1)
