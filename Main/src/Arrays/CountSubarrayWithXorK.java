package Arrays;

import java.util.HashMap;

public class CountSubarrayWithXorK {
    public static int subarrrays(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int xr = 0;
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            xr = xr ^ nums[i];
            int x = xr ^ k;
            cnt += map.getOrDefault(x, 0);
            map.put(xr,map.getOrDefault(xr, 0) + 1);
        }

        return cnt;
        
    }
    public static void main(String[] args){
        int[] nums = new int[] {4,2,2,6,4};
        int k = 6;
        System.out.println(subarrrays(nums, k));
    }
}
