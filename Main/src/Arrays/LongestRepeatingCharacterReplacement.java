package Arrays;

import java.util.Arrays;

public class LongestRepeatingCharacterReplacement{
    public static int lrcr(String s, int k){
        int n = s.length();
        int[] hash = new int[26];
        Arrays.fill(hash, 0);
        int ans = 0;
        int max = 0;
        int l = 0;
        int r = 0;
        while(r < n){
            hash[s.charAt(r) - 'A']++;
            max = Math.max(max, hash[s.charAt(r) - 'A']);
            if((r - l + 1) - max > k){
                hash[s.charAt(l) - 'A']--;
                l++;
            }
            if ((r - l + 1) - max <= k) {
                ans = Math.max(ans, (r - l + 1));
            }
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String input = "AAABBCCD";
        int k = 2;
        System.out.println(lrcr(input, k));
    }
}