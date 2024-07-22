package Striver_SDE_sheet.Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    public static ArrayList<Integer> subsetSums(int[] arr, int n) {
        
        ArrayList<Integer> s = new ArrayList<>();
        
        s.add(0);

        for (int i = 0; i < n; i++) {
            int v = s.size();
            for (int t = 0; t < v; t++) {
                s.add(s.get(t) + arr[i]); 
            }
        }

        return s;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 1};
        List<Integer> ans = subsetSums(nums, 3);
        System.out.println(ans);
    }
}
