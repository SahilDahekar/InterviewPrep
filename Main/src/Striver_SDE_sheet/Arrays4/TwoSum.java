package Striver_SDE_sheet.Arrays4;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            int diff = target - n;
            if(map.containsKey(diff)){
                return new int[]{ map.get(diff), i};
            }
            map.put(n, i);
        }

        return new int[]{-1, -1};
    }
    
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}