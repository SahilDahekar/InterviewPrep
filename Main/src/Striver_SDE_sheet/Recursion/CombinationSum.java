package Striver_SDE_sheet.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> curr){
        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        if(arr[ind] <= target){
            curr.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, curr);
            curr.remove(curr.size() - 1);
        }

        findCombinations(ind + 1, arr, target, ans, curr);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> ans = combinationSum(candidates, target);
        for(List<Integer> a : ans){
            System.out.println(a);
        }
    }
}
