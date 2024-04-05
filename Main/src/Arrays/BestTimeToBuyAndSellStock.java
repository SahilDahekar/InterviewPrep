package Arrays;

public class BestTimeToBuyAndSellStock {
    public static int getBestTime(int[] stocks){
        int n = stocks.length;
        int profit = 0;
        int mini = stocks[0];
        int cost = 0;   
        for (int i = 1; i < n; i++) {
            cost = stocks[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, stocks[i]);
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,1,2,5,6,4};
        System.out.println(getBestTime(nums));
    }
}
