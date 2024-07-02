package Striver_SDE_sheet.Arrays4;

import java.util.HashSet;

public class LongestConsequetiveSequence {

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }

        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for(int ele : nums){
            if(!set.contains(ele - 1)){
                cnt = 1;
                int x = ele;
                while(set.contains(x + 1)){
                    cnt++;
                    x += 1;
                }
            }
            max = Math.max(max, cnt);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}
