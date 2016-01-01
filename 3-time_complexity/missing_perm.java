// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

//100 percent correctness score

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int complete_sum = 0;
        int sum = 0;
        for (int i = 1; i <= A.length + 1; i ++) {
            complete_sum += i;
        }
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return complete_sum - sum;
    }
}