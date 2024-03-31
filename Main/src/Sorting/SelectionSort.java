package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static int[] selectionSort(int[] nums){
        int min;
        for(int i = 0; i < nums.length; i++){
            min = i;
            for(int j = i; j < nums.length; j++){
                if(nums[j] < nums[min]){
                    min = j;
                }
            }
            swap(i,min,nums);
            System.out.println(i + "th iteration : " + Arrays.toString(nums));
        }

        return nums;
    }

    public static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] nums = new int[]{5, 2, 8, 1, 9, 3, 7, 4, 6};
        System.out.println(Arrays.toString(selectionSort(nums)));
    }
    
}
