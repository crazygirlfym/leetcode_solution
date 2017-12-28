package leetcode;
// 两个数组 最长重复的子串
public class Solution_718 {
	// A: [1,2,3,2,1]
	// B: [3,2,1,4,7]
//	public int findLength(int[] A, int[] B) {
//        int n = A.length;
//        int m = B.length;
//        int max =0;
//        int[] dp = new int[m+1];
//        for(int i=1; i<=n ;i++) {
//        		for(int j=m; j>0 ;j--) {
//        			if (A[i-1] == B[j-1]) {
//        				dp[j] = dp[j-1] + 1;
//        			}else {
//        				dp[j] = 0;
//        			}
//        			max = Math.max(max, dp[j]);
//        		}
//        }
//        return max;
//    }
	// 思路2，如果把数组换成是字符串，则分别求的就是最长重复子串了(Longest Common Substring), 和不连续的子串不同的是，这个序列必须是连续的，
	// 如果A[i] ==B[j]， 只需要加上左上方的dp值，如果不相等，直接赋值为0表示不匹配，不能再增加长度即可
	public int findLength(int[] A, int[] B) {
		int max = 0;
		int n = A.length, m = B.length;
		int[][] dp = new int[n+1][m+1];
		for(int i=1; i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				if(A[i-1] ==B[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
				else dp[i-1][j-1] =0;
				max =Math.max(max, dp[i][j]);
			}
			
		}
		return max;
		
	}
	
	public static void main(String[] args) {
		Solution_718 s = new Solution_718();
		int[] A = new int[] {1, 2, 3, 2, 1};
		int[] B = new int[] {3, 2, 1, 4, 7};
		System.out.println(s.findLength(A, B));
	}
}	
