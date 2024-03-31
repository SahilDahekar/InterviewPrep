package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] nums){
        if(nums.length == 1){
            return nums;
        }
        int mid = nums.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(left, right);
    }
    
    public static int[] merge(int[] a, int[] b){
        int[] mix = new int[a.length + b.length];
        int l1 = 0;
        int l2 = 0;
        int k = 0;
        
        while(l1 < a.length && l2 < b.length){
            if(a[l1] < b[l2]){
                mix[k++] = a[l1++];
            } else {
                mix[k++] = b[l2++];
            }
        }

        while(l1 < a.length){
            mix[k++] = a[l1++];
        }

        while(l2 < b.length){
            mix[k++] = b[l2++];
        }

        return mix;
    }

    public static void mergeSortInPlace(int[] nums, int s ,int e){
        if(e - s == 1){
            return;
        }

        int mid = (s + e)/2;
        mergeSortInPlace(nums, s, mid);
        mergeSortInPlace(nums, mid, e);

        mergeInPlace(nums, s, mid, e);
    }

    public static void mergeInPlace(int[] nums, int s, int mid, int e){
        int[] mix = new int[e - s];

        int l1 = s;
        int l2 = mid;
        int k = 0;

        while(l1 < mid && l2 < e){
            if(nums[l1] < nums[l2]){
                mix[k++] = nums[l1++];
            } else {
                mix[k++] = nums[l2++];
            }
        }

        while(l1 < mid){
            mix[k++] = nums[l1++];
        }

        while(l2 < e){
            mix[k++] = nums[l2++];
        }

        for(int i = 0; i < mix.length; i++){
            nums[s+i] = mix[i];
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{5, 2, 8, 1, 9, 3, 7, 4, 6};
        // System.out.println(Arrays.toString(mergeSort(nums)));
        mergeSortInPlace(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
