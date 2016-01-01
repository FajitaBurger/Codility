// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

//100 percent correctnes score

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        long backward_sum = sum;
        long forward_sum = 0;
        long min_diff = Long.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            forward_sum += A[i];
            backward_sum -= A[i];
            long abs_diff = Math.abs(forward_sum - backward_sum);
            if (abs_diff < min_diff) {
                min_diff = abs_diff;
            }
        }
        
        return (int)min_diff;
    }
}