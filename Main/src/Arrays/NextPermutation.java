package Arrays;

import java.util.Arrays;

public class NextPermutation {
    public static int[] getNextPermutation(int[] nums){
        int idx = -1;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]){
                idx = i;
                break;
            }
        }

        if(idx == -1){
            return reverse(nums, 0, n - 1);
        }

        for(int i = n -1; i > idx; i--){
            if(nums[i] > nums[idx]){
                swap(nums, idx, i);
                break;
            }
        }

        return reverse(nums, idx + 1, n - 1);
    }

    public static void swap(int[] nums, int a , int b){
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }

    public static int[] reverse(int[] nums, int s, int e){
        while(s <= e){
            swap(nums, s, e);
            e--;
            s++;
        }
        return nums;
    }

    public static void main(String[] args){

        int[] nums = new int[]{2,1,5,4,3,0,0};
        System.out.println(Arrays.toString(getNextPermutation(nums)));
    }
}
