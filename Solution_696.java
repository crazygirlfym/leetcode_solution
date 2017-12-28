package leetcode;

public class Solution_696 {
	// 最暴力的方法就是 取所有的子串，判断是不是有相同的0 和相同的1
	// 在判断是不是有相同的0， 1复杂度是o(n) 整个复杂度基本上是o(n^3) 复杂度太高了
	
	// 其实是比较两个相邻连续的数字，取小的 ，
	     public int countBinarySubstrings(String s) {
	         int pre = 0;
	         int cur = 1;
	         int result = 0;
	         for(int i=1; i<s.length();i++) {
	        	 if(s.charAt(i) == s.charAt(i-1)) cur ++;
	        	 else {
	        		 pre = cur;
	        		 cur = 1;
	        	 }
	        	 if(pre >= cur) result ++;
	         }
	         return result;
	    }
	public static void main(String[] args) {
		Solution_696 s = new Solution_696();
		System.out.println(s.countBinarySubstrings("00110011"));
	}
}
