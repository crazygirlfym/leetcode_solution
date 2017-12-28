package leetcode;

public class Solution_650 {
	 int minstep = Integer.MAX_VALUE;
	 public int minSteps(int n) {
		 if(n == 1) {
			 return 0;
		 }
		 helper(n,0,0,1);
		 return minstep;
	 }
	 public void helper(int n, int step, int tmp ,int last) {
		 if (tmp == n) {
			 minstep = Math.min(step, minstep);
			 return;
		 }
		 if(tmp > n ) {
			 return;
		 }
		 if (step != 0 && tmp ==0) return;
		 int nn = tmp;
		 helper(n, step+2, tmp + tmp, tmp);
		 helper(n, step+1,tmp+last,last);
	 }
	
	 
	 public static void main(String[] args) {
		Solution_650 s = new Solution_650();
		System.out.println(s.minSteps(2));
	}
}
