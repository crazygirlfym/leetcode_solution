package leetcode;

import java.util.Arrays;

// 给定的pairs 也不是有序的
public class Solution_646 {
	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
		int result = 0;
		int n = pairs.length;
		int dp[] = new int[n];
		 for (int i = 0; i < n; i++) dp[i] = 1;
		 
		 for(int i=1;i<n;i++) {
			 for(int j=0;j<i;j++) {
				 if(pairs[i][0] > pairs[j][1] && dp[i] < dp[j] + 1) {
					 dp[i] = dp[j] + 1;
				 }
			 }
		 }
		 
		 for(int i=0;i<n;i++)
			 result = Math.max(dp[i], result);
		 return result;
	        
    }
}
