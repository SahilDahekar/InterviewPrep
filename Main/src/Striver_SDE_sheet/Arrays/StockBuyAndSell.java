package Arrays;

public class StockBuyAndSell {
    public static int maxProfit(int[] prices){

        int mini = prices[0];
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            int cost = prices[i] - mini;
            max = Math.max(max, cost);
            mini = Math.min(mini, prices[i]);
        }

        return max;
    }
    
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }
}
