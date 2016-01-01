// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");


//100 percent correct

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        int [] numspace = new int[N+1];
        for (int i = 0; i<numspace.length; i++) {
            numspace[i] = 0;
        }
        int min_positive = 1;
        for (int i = 0; i < N; i++) {
            if (A[i] >= 0 && A[i] <= N) {
                numspace[A[i]]++;
                if (A[i] == min_positive) {
                    while (min_positive <= N && numspace[min_positive] != 0) {
                        min_positive++;
                    }
                }
            }
        }
        return min_positive;
    }
}