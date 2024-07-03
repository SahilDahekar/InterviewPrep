package Arrays4;

import java.util.HashMap;

public class LargestSubarrayWIthXor {
    public static int solve(int[] arr, int k) {

        int cnt = 0;
        int xr = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i = 0; i < arr.length; i++) {
            xr = xr ^ arr[i];

            int x = xr ^ k;

            if(map.containsKey(x)){
                cnt += map.get(x);
            }

            if(map.containsKey(xr)){
                map.put(xr, map.get(xr) + 1);
            } else {
                map.put(xr, 1);
            }
        }

        return cnt;
        
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;

        System.out.println(solve(arr, k));
    }
}
