package Arrays4;

import java.util.HashMap;

public class LargestSubarrayWithSumZero{
    public static int maxLen(int arr[], int n){
    
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            sum += arr[i];
            
            if(sum == 0){
                max = Math.max(max, i + 1);
            }
            
            int rem = sum - 0;
            
            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                max = Math.max(max, len);
            }
            
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        } 
        
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {15,-2,2,-8,1,7,10,23};
        int n = 8;
        System.out.println(maxLen(arr, n));
    }
}
