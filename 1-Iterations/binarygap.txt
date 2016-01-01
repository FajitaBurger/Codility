// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        int gap = 0;
        int max_gap = 0;
        long one = 1;
        long number = N;
        for (long i = 32; i >= 0; i--) {
            long mask = one << i;
            if (mask < number) {
                //System.out.println(mask & number);
                if ((number & mask) == 0) {
                    gap++;
                    //System.out.println(gap);
                } else {
                    if (gap > max_gap) {
                        max_gap = gap;
                    }
                    gap = 0;
                }
            }
        }
        return max_gap;
    }
}