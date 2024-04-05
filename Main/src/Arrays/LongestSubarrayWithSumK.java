package Arrays;

import java.util.HashMap;

public class LongestSubarrayWithSumK {
    public static int getLongestSubarray(int[] nums, int k){
        int n = nums.length;
        int sum = nums[0];
        int l = 0;
        int r = 0;
        int max = Integer.MIN_VALUE;
        while(r < n) {
            while(sum > k && l <= r){
                sum -= nums[l];
                l++;
            }

            if(sum == k){
                max = Math.max(max, (r - l + 1));
            }

            r++;

           if(r < n){
                sum += nums[r];
           }

        }

        return max;
    }

    // With negative values also present in the array
    public static int getLongestSubarrayWithNegatives(int[] nums, int k){
        int n = nums.length;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if(sum == k){
                max = Math.max(max, i + 1);
            }

            int rem = sum - k;
            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                max = Math.max(max, len);
            }

            if(!map.containsKey(rem)){
                map.put(rem, i);
            }
        }

        return max;
    }
    
    public static void main(String[] args){
        // int[] nums = new int[] {1,2,3,1,1,1,1,4,2,3};
        // int[] nums = new int[] {1,2,1,3};
        int[] nums = new int[] {-1, 1, 1};
        int k = 1;
        // System.out.println(getLongestSubarray(nums, k));
        System.out.println(getLongestSubarrayWithNegatives(nums, k));
    }
}
