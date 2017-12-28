package leetcode;
//edit distance
public class Solution_583 {
	 public int minDistance(String word1, String word2) {
		 if(word1.equals("")) {
			 return word2.length();
		 }
		 if(word2.equals("")) {
			 return word1.length();
		 }
		 
		 int[][]dp = new int[word1.length() + 1][word2.length()+1];
		 
		 
		 
		 for(int i=0;i<word1.length()+1;i++) {
			 for(int j=0; j< word2.length()+1;j++) {
				 dp[i][j] = Integer.MAX_VALUE;
			 }
		 }
		 
		 for(int i=0;i<word1.length()+1;i++) {
			 dp[i][0] = i;
			
		 }
		 for(int i=0;i<word2.length()+1;i++) {
			 dp[0][i]  = i;
		 }
		 

	        
			 for(int i=1;i<word1.length()+1;i++) {
				 for(int j=1;j<word2.length()+1;j++) {
					 if(word1.charAt(i-1) == word2.charAt(j-1)) {
						 dp[i][j] = dp[i-1][j-1]; 	 
					 }else {
						 dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
					 }
					 
				 }
			 }
		return dp[word1.length()][word2.length()];
	    }
	 public static void main(String[] args) {
		 Solution_583 s = new Solution_583();
		 System.out.println(s.minDistance("a", "b"));
	}
}
