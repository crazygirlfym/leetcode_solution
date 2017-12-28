package leetcode_top100;

public class Solution_Decode_Ways {
	 public int numDecodings(String s) {
	        if(s == null || s.length() == 0) {
	        		return 0;
	        }
	        
	        int n = s.length();
	        // 用dp[i] 表示字符串前i个字符串能表示的解码个数，那么它依赖于dp[i-1] dp[i-2]
	        int [] dp = new int[n+1];
	        dp[0] = 1;
	        dp[1] = s.charAt(0) != '0' ? 1:0;
	        for(int i=2; i<=n ;i++) {
	        		int first = Integer.valueOf(s.substring(i-1, i));
	        		int second = Integer.valueOf(s.substring(i-2, i));
	        		
	        		if(first >=1 && first <=9) {  // 表示可以独自成为1个数
	        			dp[i] += dp[i-1];
	        		}
	        		if(second >=10 && second <=26) { //表示可以组成两位数
	        			dp[i] += dp[i-2];
	        		}
	        			
	        }
	        
	        return dp[n];
	    }
}
