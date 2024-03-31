package Sorting;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] nums){

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length - i - 1; j++){
                if(nums[j] > nums[j+1]){
                    swap(j,j+1,nums);
                }
            }
            System.out.println(i + "th iteration : " + Arrays.toString(nums));
        }

        return nums;
    }

    public static int[] optimizedBubbleSort(int[] nums){

        boolean sorted;

        for(int i = 0; i < nums.length; i++){
            sorted = true;
            for(int j = 0; j < nums.length - i - 1; j++){
                if(nums[j] > nums[j+1]){
                    sorted = false;
                    swap(j,j+1,nums);
                }
            }
            if(sorted){
                break;
            }
            System.out.println(i + "th iteration : " + Arrays.toString(nums));
        }

        return nums;
    }

    public static void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 8, 1, 9, 3, 7, 4, 6};
        // System.out.println("Brute Force : " + Arrays.toString(bubbleSort(nums)));
        System.out.println("Optimized : " + Arrays.toString(optimizedBubbleSort(nums)));
    }
}
