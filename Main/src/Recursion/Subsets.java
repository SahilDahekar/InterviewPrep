package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/description/

public class Subsets {
    public static void subsets(int ind, int[] nums, List<Integer> curr, List<List<Integer>> ans){
        ans.add(new ArrayList<>(curr));

        for(int i = ind; i < nums.length; i++){
            if(i > ind && nums[i] == nums[i - 1]){
                continue;
            }

            curr.add(nums[i]);
            subsets(i + 1, nums, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,2};
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subsets(0, nums, new ArrayList<>(), ans);

        System.out.println(Arrays.toString(ans.toArray()));
    }
}
