package Arrays;

import java.util.Arrays;

public class MaximumSubarraySum {
    public static int maxSum(int[] nums){
        int sum = 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if(sum > max){
                max = sum;
            }

            if(sum < 0){
                sum = 0;
            }
        }

        return max;
    }

    public static int[] getMaxSumArray(int[] nums){
        int sum = 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int s_idx = -1;
        int e_idx = -1;
        int start = 0;

        for (int i = 0; i < n; i++) {
            if(sum == 0){
                start = i;
            }
            sum += nums[i];

            if(sum > max){
                max = sum;
                s_idx = start;
                e_idx = i;
            }

            if(sum < 0){
                sum = 0;
            }
        }

        return new int[] {s_idx, e_idx};
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSum(nums));
        // System.out.println(Arrays.toString(getMaxSumArray(nums)));
    }
}
