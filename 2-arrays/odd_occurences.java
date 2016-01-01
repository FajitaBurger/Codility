// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

//100 percent correctness score

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
            //System.out.println(what_this);
        }
        return xor;
    }
}