package leetcode;

public class Solution_309 {
	public int maxProfit(int[] prices) {
       int buy = Integer.MIN_VALUE;
       int pre_buy = 0;
       int sell = 0;
       int pre_sell = 0;
       for(int price:prices) {
    	   	pre_buy = buy;
    	   	buy = Math.max(pre_sell - price, pre_buy);
    	   	pre_sell = sell;
    	   	sell = Math.max(pre_buy + price, pre_sell);
       }
        return sell;
    }
}
