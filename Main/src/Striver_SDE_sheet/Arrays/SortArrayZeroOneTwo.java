package Arrays;

import java.util.Arrays;

public class SortArrayZeroOneTwo {

    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while(mid <= high){
            if(nums[mid] == 2){
                swap(nums, mid, high);
                high--;
            } else if (nums[mid] == 0){
                swap(nums, mid, low);
                mid++;
                low++;
            } else if (nums[mid] == 1){
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
