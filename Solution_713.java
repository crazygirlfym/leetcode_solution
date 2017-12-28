package leetcode;

public class Solution_713 {
	// 本题在于是要连续的数组子串  
	
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if(k<2) return 0;
		int result = 0;
		int product =1;
		for(int i=0, right=0;right<nums.length; right ++) {
			product *= nums[right];
			while(i<nums.length && product >=k) {
				product /=nums[i++];
			}
			result += right-i + 1;
		}
		return result;
	}
	public static void main(String[] args) {
		Solution_713 s = new Solution_713();
		int[] nums = new int[] {10, 5, 2, 6};
		System.out.println(s.numSubarrayProductLessThanK(nums, 100));
	}
}
