package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://www.geeksforgeeks.org/problems/subset-sums2234/1

public class SubsetSum {
    public static void subsetSum(int ind, int[] arr, int sum, List<Integer> result){
        if(ind == arr.length){
            result.add(sum);
            return;
        }

        subsetSum(ind + 1, arr, sum + arr[ind], result);

        subsetSum(ind + 1, arr, sum, result);
    }

    public static void main(String[] args) {

        int[] arr = new int[]{5, 2, 1}; 
        List<Integer> result = new ArrayList<>();
        subsetSum(0, arr, 0, result);
        Collections.sort(result);

        System.out.println(Arrays.toString(result.toArray()));

    }
}
