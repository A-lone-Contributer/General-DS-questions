// To compute the parity of a word


/*
Approach 1 : Brute Force [ Time : O(n) |  Space : O(1) ]

The brute-force algorithm iteratively tests the value of each bit while track¬ ing the number of Is seen so far.
Since we only care if the number of Is is even or odd, we can store the number modulo 2


Approach 2 : Lookup Cache Table [ Time : O(n/L) ]

To lookup the parity of the first two bits in (11101010), we right shift by 6, to get (00000011), and use this as an
index into the cache. To lookup the parity of the next two bits, i.e., (10), we right shift by 4, to get (10) in the two
least-significant bit places. The right shift does not remove the leading (11)—it results in (00001110). We cannot index
the cache with this, it leads to an out-of-bounds access. To get the last two bits after the right shift by 4, we
bitwise-AND (00001110) with (00000011) (this is the "mask" used to extract the last 2 bits). The result is (00000010).
Similar masking is needed for the two other 2-bit lookups.

The time complexity is a function of the size of the keys used to index the lookup table. Let L be the width of the words
for which we cache the results, and n the word size. Since there are n/L terms, the time complexity is 0(n/L),assuming
word level operations, such as shifting, take 0(1) time. (This does not include the time for initialization of the lookup
table.)

Approach 3 : Associativity [ Time : O(n*log(n)) | Space : O(1) ]

XOR has the property of being associative (as previously described), as well as commutative, i.e., the order in which we
perform the XORs does not change the result. The XOR of a group of bits is its parity. We can exploit this fact to use
the CPU's  word-level XOR instruction to process multiple bits at a time.

*/


public class core {

    // Approach 1
    public static short bruteForce(long x) {
        short result = 0;
        while (x != 0) {
            result ^= (x & 1);
            x >>>= 1;
        }
        return result;
    }

    // Approach 2
    private static final short[] precomputedParity;

    static {
        precomputedParity = new short[1 << 16];
        for (int i = 0; i < (1 << 16); ++i) {
            precomputedParity[i] = bruteForce(i);
        }
    }

    public static short parityTable(long x) {
        final int WORD_SIZE = 16;
        final int BIT_MASK = 0xFFFF;

        short result = precomputedParity[(int) (x & BIT_MASK)];
        x = x >>> WORD_SIZE;
        result ^= precomputedParity[(int) (x) & BIT_MASK];
        x = x >>> WORD_SIZE;
        result ^= precomputedParity[(int) (x) & BIT_MASK];
        x = x >>> WORD_SIZE;
        result ^= precomputedParity[(int) (x) & BIT_MASK];
        return result;
    }

    // Approach 3
    private static short parityAssoc(long x) {

        // recursively divide the (32-bit) integer into two equal
        // halves and take their XOR until only 1 bit is left
        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;

        // return the last bit
        return (short)(x & 0x1);
    }

    // driver code
    public static void main(String[] args) {
        System.out.println(bruteForce(0b0111111111111111111111111111111111111111111111111111111111111111L));
        System.out.println(parityTable(0b0111111111111111111111111111111111111111111111111111111111111111L));
        System.out.println(parityAssoc(0b0111111111111111111111111111111111111111111111111111111111111111L));

    }
}
