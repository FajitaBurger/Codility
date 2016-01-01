// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int [] arrayF(int N) {
        int [] F = new int [N];
        for (int i = 2; 2 * i <= N; i++) {
            if (F[i-1] == 0) {
                if (F[i-1] != 0) continue;
                F[i-1] = i;
                int k = i*i;
                while(k <= N) {
                    if (F[k-1] == 0) F[k-1] = i;
                    k += i;
                }
            }
        }
        return F;
    }
                
    
    public int[] solution(int N, int[] P, int[] Q) {
        // write your code in Java SE 8
        int [] factor_count = new int[N];
        int M = P.length;
        int [] result = new int[M];

        int [] F = arrayF(N);
        
        /*for (int i = 0; i < N; i++ ) {
            System.out.print(F[i]);
        }
        System.out.println();*/
        
        for (int i = 2; i<=N; i++) {
            if (F[i - 1] == 0) continue;
            factor_count[i - 1] = 1;
            factor_count[i - 1] += factor_count[(i/(F[i - 1])) - 1];
        }
        
        /*for (int i = 0; i < N; i++ ) {
            System.out.print(factor_count[i]);
        }
        System.out.println();*/
        
        int [] semi_prime_prefix = new int[N];
        for (int i = 1; i < N; i++) {
            semi_prime_prefix[i] = semi_prime_prefix[i - 1];
            if (factor_count[i] == 2) semi_prime_prefix[i]++;
        }
        
        /*for (int i = 0; i < N; i++ ) {
            System.out.print(semi_prime_prefix[i]);
        }
        System.out.println();*/
        
        for (int i = 0; i < M; i++) {
            int start = P[i] - 1;
            if (start > 0) start--; //because we count inclusive of bounds
            int end = Q[i] - 1;
            result[i] = semi_prime_prefix[end] - semi_prime_prefix[start];
        }
        
        return result;
        
        /*for (int i = 0; i < N; i++ ) {
            System.out.print(factor_count[i]);
        }
        System.out.println();
        
        for (int i = 2; 2*i <= N; i++) {
            int multiple = i;
            System.out.println(i);
            if (factor_count[multiple - 1] != 0) continue;
            while (multiple <= N) {
                factor_count[multiple - 1] ++;
                multiple += i;
            }
            for (int j = 0; j < N; j++ ) {
                System.out.print(factor_count[j]);
            }
            System.out.println();
        }
        for (int i = 0; i < N; i++ ) {
            System.out.print(factor_count[i]);
        }
        return result;
        */
    }
}