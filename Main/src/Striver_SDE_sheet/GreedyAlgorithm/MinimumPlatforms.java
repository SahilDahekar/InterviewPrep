package GreedyAlgorithm;

import java.util.Arrays;

public class MinimumPlatforms {
    public static int findPlatform(int arr[], int dep[], int n)
    {
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int cnt = 1;
        int max = 1;
        int i = 1;
        int j = 0;
        
        while(i < n && j < n){
            
            if(arr[i] <= dep[j]){
                cnt++;
                i++;
            } else {
                cnt--;
                j++;
            }
            
            max = Math.max(max, cnt);
        }
        
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, dep, 6));
    }
}
