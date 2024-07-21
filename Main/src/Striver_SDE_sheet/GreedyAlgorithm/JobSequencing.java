package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class jobComparator implements Comparator<Job>{
    public int compare(Job j1, Job j2){
        if(j1.profit > j2.profit){
            return -1;
        }
        
        if(j1.profit < j2.profit){
            return 1;
        }
        
        return 0;
    }
}

public class JobSequencing {
    
    public static int[] JobScheduling(Job arr[], int n){
    
        Arrays.sort(arr, new jobComparator());
        
        // for(Job j : arr){
        //     System.out.print("Id : " + j.id + " ");
        //     System.out.print("Profit : " + j.profit + " ");
        //     System.out.print("Deadline : " + j.deadline + " ");
        //     System.out.println();
        // }
        
        int cnt = 0;
        int profit = 0;
        
        boolean[] slot = new boolean[n];
        
        Arrays.fill(slot, false);
        
        for(int i = 0; i < n; i++){
            for(int j = arr[i].deadline - 1; j >= 0; j--){
                if(slot[j] == false){
                    cnt++;
                    slot[j] = true;
                    profit += arr[i].profit;
                    break;
                } 
            }   
        }
        
        int[] ans = new int[2];
        ans[0] = cnt;
        ans[1] = profit;
        
        return ans;
    }
    
    public static void main(String[] args) {
        Job[] arr = new Job[4];
        arr[0] = new Job(1, 4, 20);
        arr[1] = new Job(2, 1, 10);
        arr[2] = new Job(3, 2, 40);
        arr[3] = new Job(4, 2, 30);

        int[] ans = JobScheduling(arr, 4);
        System.out.println(Arrays.toString(ans));
    }
}
