// To count the number of bits that are set to 1

public class core {

    // function to count set bits
    public static short countBits(int x) {
        short numBits = 0;
        
        while (x != 0) {
            numBits += (x & 1);
            x >>>= 1;
        }
        return numBits;
    }

    // driver code
    public static void main(String[] args) {
        System.out.println(countBits(20));
    }
}

