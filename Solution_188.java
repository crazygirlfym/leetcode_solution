package leetcode;

public class Solution_188 {
	// 用两个变量 
	//hold[i][j]表示 到第i天进行j次交易 手里仍持有股票时候的最大值 hold[i][j] = max(hold[i-1][j] - prices[i], hold[i-1][j])
	//unhold[i][j]表示到第i天进行j次交易 手里没有持有股票时候的最大值unhold[i][j] = max(unhold[i-1][j], hold[i-1][j-1]+prices[i])
	
	public int maxProfit(int k, int[] prices) {
        if(k>prices.length/2) return maxP(prices);
        int[][] hold = new int[prices.length][k+1];
        int[][] unhold = new int[prices.length][k+1];
        hold[0][0] = -prices[0];
        for(int i=1;i<prices.length;i++) hold[i][0] = Math.max(hold[i-1][0],-prices[i]);
        for(int j=1;j<=k;j++) hold[0][j] = -prices[0];
        for(int i=1;i<prices.length;i++){
            for(int j=1;j<=k;j++){
                hold[i][j] = Math.max(unhold[i-1][j]-prices[i],hold[i-1][j]);
                unhold[i][j] = Math.max(hold[i-1][j-1]+prices[i],unhold[i-1][j]);
            }
        }
        return Math.max(hold[prices.length-1][k],unhold[prices.length-1][k]);
     
    }
	  public int maxP(int[] prices){
	        int res =0;
	        for(int i=0;i<prices.length;i++){
	            if(i>0 && prices[i] > prices[i-1]){
	                res += prices[i]-prices[i-1];
	            }
	        }
	        return res;
	    }
	
}
