package Arrays;

import java.util.Arrays;

public class NumberOfSubstringThreeCharacters {
    public static int numberOfSubstrings(String s) {
        int n = s.length();
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen, -1);

        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for(int i = 0; i < n; i++){
            lastSeen[s.charAt(i) - 'a'] = i;
            min = Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]);
            if(min != -1){
                cnt += 1 + min;
            }
        }

        return cnt;
    }

    public static void main(String[] args){
        String input = "abcabc";
        System.out.println(numberOfSubstrings(input));
    }
}
