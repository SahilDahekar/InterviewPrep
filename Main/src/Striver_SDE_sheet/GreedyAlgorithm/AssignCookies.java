package GreedyAlgorithm;

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        int m = g.length;
        int n = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0;
        int r = 0;

        while(l < n && r < m){
            if(g[r] <= s[l]){
                r++;
            }
            l++;
        }

        return r;
    }
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};

        System.out.println(findContentChildren(g, s));
    }
}
