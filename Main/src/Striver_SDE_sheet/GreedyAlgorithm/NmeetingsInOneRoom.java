package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

class pair{
    int start;
    int end;
    
    public pair(int start , int end){
        this.start = start;
        this.end = end;
    }
}

public class NmeetingsInOneRoom{

    public static int maxMeetings(int start[], int end[], int n){

        pair[] x = new pair[n];
        
        for(int i = 0; i < n; i++){
            x[i] = new pair(start[i], end[i]);
        }
        
        Arrays.sort(x, new Comparator<pair> () {
            
            public int compare(pair s1, pair s2){
                return s1.end - s2.end;
            }
        });
        
        int last = -1;
        int res = 0;
        
        for(int i = 0; i < n; i++){
            if(x[i].start > last){
                res++;
                last = x[i].end;
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] start = {1,3,0,5,8,5};
        int[] end =  {2,4,6,7,9,9};

        System.out.println(maxMeetings(start, end, n));
    }
}