package Arrays;

import java.util.Arrays;

public class LongestSubstringDistinct {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int l = 0;
        int r = 0;
        int max = Integer.MIN_VALUE;
        while(r < s.length()){
            int val = hash[s.charAt(r)];
            if(val != -1 && val >= l){
                l = val + 1;
            }
            max = Math.max(max, r - l + 1);
            hash[s.charAt(r)] = r;
            r++;
        }

        return max;
    }

    public static void main(String[] args){
        String str = "cadbzabcd";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
