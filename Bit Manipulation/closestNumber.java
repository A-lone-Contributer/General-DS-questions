// Find closest integer with same weight

/*

Approach :

Suppose we flip the bit at index k1 and flip the bit at index k2, kl > k2. Then the absolute value of the difference
between the original integer and the new one is 2^(k1) - 2^(k2). To minimize this, we should make kl as small as possible and
k2 as close to k1. Since we must preserve the weight, the bit at index k1 has to be different from the bit in k2, otherwise
the flips lead to an integer with different weight. This means the smallest k1 can be is the rightmost bit that's different
from the LSB, and k2 must be the very next bit. In summary, the correct approach is to swap the two rightmost consecutive
bits that differ.

 */

public class core {

    static final int NUM_UNSIGNED_BITS = 63;

    public static long closestIntSameBitCount(long x) {

        // x is assumed to be non-negative so we know the leading bit is 0.
        // We restrict to our attention to 63 LSBs.
        for (int i = 0; i < NUM_UNSIGNED_BITS - 1; i++) {
            if (((x >>> i) & 1) != ((x >>> (i + 1)) & 1)) {
                x ^= (1L << i) | (1L << (i + 1)); // Swaps bit-i and bit-(i + 1)
                return x;
            }
        }
        // Throw error if all bits of x are 0 or 1.
        throw new IllegalArgumentException("All bits are or 1");
    }

    public static void main(String[] args) {
        System.out.println(closestIntSameBitCount(10));
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
