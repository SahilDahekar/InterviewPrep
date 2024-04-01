package Arrays;

import java.util.HashSet;

public class LongestConsecutiveSequence{

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int longest = 1;
        int cnt = 1;

        if(nums.length == 0){
            return 0;
        }
        for(int i = 0; i < nums.length ; i++){
            set.add(nums[i]);
        }
        for(int ele : set){
            if(!set.contains(ele - 1)){
                cnt = 1;
                int x = ele;
                while(set.contains(x+1)){
                    cnt++;
                    x++;
                }
            }
            longest = Math.max(cnt,longest);
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}