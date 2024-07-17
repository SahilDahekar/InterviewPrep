package LinkedListAndArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            search(nums, -nums[i], i + 1, list);
        }

        return list;
    }

    public static void search(int[] nums, int targetSum, int left, List<List<Integer>> list){
        int right = nums.length - 1;
        while(left < right){
            int curr = nums[left] + nums[right];
            if(curr == targetSum){
                list.add(Arrays.asList(-targetSum, nums[left], nums[right]));
                left++;
                right--;
                while(left < right && nums[left] == nums[left - 1]){
                    left++;
                }
                while(left < right && nums[right] == nums[right + 1]){
                    right--;
                }
            } else if (curr < targetSum) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> l = threeSum(nums);
        for (List<Integer> n : l) {
            System.out.println(n);
        }
    }
}