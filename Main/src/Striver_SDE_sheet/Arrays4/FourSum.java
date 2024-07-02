package Striver_SDE_sheet.Arrays4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < n - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                search(nums, i, j, target, res);
            }
        }

        return res;
    }

    public static void search(int[] nums, int first, int second, int target, List<List<Integer>> res){
        int left = second + 1;
        int right = nums.length - 1;
        while(left < right){
            long currSum = nums[first] + nums[second] + nums[left] + nums[right];
            if(currSum == target){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[first]);
                temp.add(nums[second]);
                temp.add(nums[left]);
                temp.add(nums[right]);
                res.add(temp);
                left++;
                right--;
                while(left < right && nums[left] == nums[left - 1]){
                    left++;
                }
                
                while(right < nums.length - 2 && nums[right] == nums[right + 1]){
                    right--;
                }
            } else if (currSum < target){
                left++;
            } else {
                right--;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> ls = fourSum(nums, target);
        for(List<Integer> l : ls){
            System.out.println(l);
        }
    }
}
