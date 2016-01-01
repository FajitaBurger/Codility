// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // first, for each position in the array, we count the number of peaks observed so far
        int max_blocks = 0;
        int N = A.length;
        if (N < 3) return max_blocks;
        int [] peak_prefix = new int[N];
        for (int i = 1; i < N - 1; i ++) {
            peak_prefix[i] = peak_prefix[i - 1];
            if (A[i] > A[i + 1] && A[i] > A[i - 1]) {
                peak_prefix[i] = peak_prefix[i] + 1;
            }
        }
        peak_prefix[N - 1] = peak_prefix[N-2];
        /*for (int i = 0; i < peak_prefix.length; i++) System.out.print(peak_prefix[i]);
        System.out.println();*/
        //next, for increasing number of blocks we make sure that the peak count is different between the delimiters of each block - we must repect array bounds
        int num_blocks = 1;
        //number of peaks must be less than half array length
        while (num_blocks <= N/2) {
            //we assume that block sizes are made to be as even as possible for each block number
            if (N%num_blocks != 0) {
                num_blocks++;
                continue;
            }
            int blk_size = N/num_blocks;
            //System.out.println(blk_size);
            int start = 0;
            boolean blk_size_works = true;
            while (start < N) {
                int end = start + blk_size - 1;
                if (end > N - 1) end = N - 1;
                //check if there were peaks between the start and end delimiters
                //System.out.println(start);
                //System.out.println(end);
                if (peak_prefix[end] - peak_prefix[start] == 0) {
                    blk_size_works = false;
                    break;
                }
                start = start + blk_size;
                //System.out.println("loop");
            }
            if (blk_size_works) max_blocks = num_blocks;
            //System.out.println();
            num_blocks++;
        }
        return max_blocks;
    }
}