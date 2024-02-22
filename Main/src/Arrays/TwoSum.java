package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] isTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int diff = target - num;

            if(map.containsKey(diff)){
                return new int[] { map.get(diff), i};
            }

            map.put(num , i);
        }

        return new int[] {};
    }
    public static void main(String[] args){
        int[] num = new int[] {2,7,11,15};
        System.out.println(Arrays.toString(isTwoSum(num, 9)));
    }
}
