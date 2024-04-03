package DP;

import java.util.Arrays;

public class CoinChange{
    public static int minCoins(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return (dp[amount] != (amount + 1)) ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;

        // int[] coins = new int[]{1, 5, 10, 25};
        // int amount = 30;

        // int[] coins = new int[]{1};
        // int amount = 0;

        System.out.println(minCoins(coins,amount));


    }
}