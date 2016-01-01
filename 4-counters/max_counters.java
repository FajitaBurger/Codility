// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

//100 percent correctness score

class Solution {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int [] counters = new int[N];
        int current_max = 0;
        int overwrite = 0;
        /*for (int j = 0; j < N; j++) {
            System.out.print(counters[j]);
        }
        System.out.println();*/
        for (int i = 0; i < A.length; i++) {
            if (A[i] > N) {
                overwrite = current_max;
                //System.out.println(overwrite);
            } else {
                if (counters[A[i] - 1] < overwrite) {
                    counters[A[i] - 1] = overwrite + 1;
                } else {
                    counters[A[i] - 1]++;
                }
                if (counters[A[i] - 1] > current_max) {
                    current_max = counters[A[i] - 1];
                    //System.out.println(current_max);
                }
            }
            /*for (int j = 0; j < N; j++) {
                System.out.print(counters[j]);
            }
            System.out.println();*/
        }
        for (int i = 0; i < N; i++) {
            if (counters[i] < overwrite) {
                counters[i] = overwrite;
            }
        }
        return counters;
    }
}