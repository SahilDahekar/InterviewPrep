package Sorting;

import java.util.Arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] nums){

        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j > 0; j--){
                if(nums[j - 1] > nums[j]){
                    swap(j, j - 1, nums);
                } else {
                    break;
                }

            }

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
        System.out.println(Arrays.toString(insertionSort(nums)));
    }
}
