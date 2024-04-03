package Arrays;

import java.util.HashMap;

public class CountSubarrayWithSumK{
    public static int countSubarray(int[] nums, int k){
        int preSum = 0;
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i = 0; i < nums.length; i++){
            preSum += nums[i];
            int rem = preSum - k;
            cnt += map.getOrDefault(rem, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int k = 3;
        System.out.println(countSubarray(nums, k));
    }
}