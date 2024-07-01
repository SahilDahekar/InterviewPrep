package Arrays3;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementTwo{

    // Brute Force uses two for loops

    // Better Approach uses HashMap to count frequencies

    // Optimized Approach using Moore Voting Algorithm
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if(n < 2){
            for(int a : nums){
                res.add(a);
            }
            return res;
        }
        int first = nums[0];
        int second = nums[0];
        int fc = 1;
        int sc = 0;

        for(int i = 1; i < n; i++){
            if(first == nums[i]){
                fc++;
            } else if (second == nums[i]){
                sc++;
            } else if (fc == 0){
                first = nums[i];
                fc = 1;
            } else if (sc == 0){
                second = nums[i];
                sc = 1;
            } else {
                fc--;
                sc--;
            }
        }

        if(first == second){
            res.add(first);
            return res;
        }

        fc = 0;
        sc = 0;
        for(int j = 0; j < n; j++){
            if(first == nums[j]){
                fc++;
            } else if(second == nums[j]){
                sc++;
            }
        }

        if(fc > n/3){
            res.add(first);
        }

        if(sc > n/3){
            res.add(second);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(majorityElement(nums));
    }
}