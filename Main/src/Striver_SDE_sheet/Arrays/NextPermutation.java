package Arrays;

import java.util.Arrays;

public class NextPermutation {

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void reverse(int[] arr, int s, int e){
        while(s <= e){
            swap(arr,s,e);
            e--;
            s++;
        }
    }

    public static void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }

        if(idx == -1){
            reverse(nums, 0, n - 1);
            return;
        }

        for(int i = n - 1; i > idx; i--){
            if(nums[i] > nums[idx]){
                swap(nums, idx, i);
                break;
            }
        }

        reverse(nums, idx + 1, n - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

