package leetcode;

public class Solution_121 {
	public int maxProfit(int[] prices) {
        
        int min = Integer.MAX_VALUE;
       
        
        int result = 0;
        for(int i=0;i<prices.length;i++) {
        		if(prices[i] > min) {
        			result = Math.max(result, prices[i]-min);
        		}else {
        			min = prices[i];
        		}
        		
        }
        return result;
    }
	public static void main(String[] args) {
		Solution_121 s = new Solution_121();
		int[] nums = new int[] {7,1,5,3,6,4};
		System.out.println(s.maxProfit(nums));
	}
}
