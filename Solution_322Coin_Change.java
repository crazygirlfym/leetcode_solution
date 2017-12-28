package leetcode_top100;

public class Solution_322Coin_Change {
	 // 中间有一些数值可以存储， dfs???
	 // 从大的开始选 ？ 未必就是最好的选择

	 public int coinChange(int[] coins, int amount) {
		 int[] dp = new int[amount+1];
		 for(int i=0;i<dp.length;i++) {
			 dp[i] = Integer.MAX_VALUE;
		 }
		 for(int i=0;i<coins.length;i++) {
			 if (coins[i] <= amount)
				 dp[coins[i]] = 1;
		 }
		 dp[0]= 0;
//		 System.out.println(amount);
		 for(int i=0;i<amount+1;i++) {
			 for(int j=0;j < coins.length;j++) {
				 if (i >= coins[j]) {
					 if (dp[i-coins[j]] != Integer.MAX_VALUE)
						 dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
				 }
			 }
		 }
		 if(dp[amount] == Integer.MAX_VALUE) return -1;
		 return dp[amount];
		 
	 }
	 
	 public static void main(String[] args) {
		 Solution_322Coin_Change s = new Solution_322Coin_Change();
		 int[] coins = new int[]{2};
		 System.out.println(s.coinChange(coins, 0));
	}
}
