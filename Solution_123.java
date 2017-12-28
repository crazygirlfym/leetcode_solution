package leetcode;

public class Solution_123 {
	public int maxProfit(int[] prices) {
       if (prices.length<=1) return 0; 
       int len = prices.length;
       int[] formmer = new int[len];
       int[] latter  = new int[len];
       
       int minPrice = prices[0];
       int maxProfit = 0;
       for(int i=1;i<len;i++) {
    	   	int diff = prices[i] - minPrice;
    	   	if(diff<0) {
    	   		minPrice = prices[i];
    	   	}else if(diff > maxProfit) maxProfit = diff;
    	   	formmer[i] = maxProfit;
       }
       int maxPrice = prices[len-1];
       maxProfit = 0;
       for(int i=len-2;i>=0;i--) {
    	   	int diff = maxPrice -prices[i];
    	   	if(diff<0) maxPrice = prices[i];
    	   	else if(diff > maxProfit) maxProfit= diff;
    	   	latter[i] = maxProfit;
       }
       
       int sum = 0;
       maxProfit  =0;
       for(int i=0;i<len;i++) {
    	   sum = latter[i] + formmer[i];
    	   if(sum > maxProfit) maxProfit =sum;
       }
       return maxProfit;
       
    }
	

}
