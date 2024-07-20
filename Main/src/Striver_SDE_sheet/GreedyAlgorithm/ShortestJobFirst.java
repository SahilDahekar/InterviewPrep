package GreedyAlgorithm;

import java.util.Arrays;

public class ShortestJobFirst {
    public static int solve(int[] bt) {
        Arrays.sort(bt);
        int t = 0;
        int wt = 0;
        for(int i = 0; i < bt.length; i++){
            wt += t;
            t += bt[i];
        }
        
        return (wt/bt.length);
    }

    public static void main(String[] args) {
        int[] nums = {4,3,7,1,2};
        System.out.println(solve(nums));
    }
}
