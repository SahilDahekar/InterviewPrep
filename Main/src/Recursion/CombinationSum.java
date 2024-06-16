package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum/description/
// https://leetcode.com/problems/combination-sum-ii/description/

public class CombinationSum{

    public static void findCombination2(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> curr){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = ind; i < arr.length; i++){
            if(i > ind && arr[i] == arr[i - 1]){
                continue;
            }

            if(arr[i] > target){
                break;
            }

            curr.add(arr[i]);
            findCombination2(i + 1, arr, target - arr[i], ans, curr);
            curr.remove(curr.size() - 1);
        }
    }



    public static void findCombination(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> curr){
        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        if(arr[ind] <= target){
            curr.add(arr[ind]);
            findCombination(ind, arr, target - arr[ind], ans, curr);
            curr.remove(curr.size() - 1);
        }

        findCombination(ind + 1, arr, target, ans, curr);
    }

    public static void main(String[] args) {

        // Combination Sum 1

        // int[] candidates = new int[]{2,3,6,7};
        // int target = 7;
        // List<List<Integer>> ans = new ArrayList<>();
        // findCombination(0, candidates, target, ans, new ArrayList<>());
        
        // System.out.println(Arrays.toString(ans.toArray()));

        // Combination Sum 2

        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination2(0, candidates, target, ans, new ArrayList<>());
        
        System.out.println(Arrays.toString(ans.toArray()));

    }
}