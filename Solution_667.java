package leetcode;
// 1,2,3,4,5
public class Solution_667 {
	public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        for(int i=0,l=1,r=n;l<=r;i++) {
        	 result[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : l++;
        }
        return result;
        
    }
}
