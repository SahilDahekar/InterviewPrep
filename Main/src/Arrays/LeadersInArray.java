package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class LeadersInArray{
    public static ArrayList<Integer> leaders(int[] nums){
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> leaders = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] > max){
                leaders.add(0,nums[i]);
                max = nums[i];
            }
        }

        return leaders;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,22,12,3,0,6};
        System.out.println(Arrays.toString(leaders(nums).toArray()));
    }
}