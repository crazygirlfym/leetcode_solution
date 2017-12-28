package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// time exceed
public class Solution_611 {
	public int triangleNumber(int[] nums) {
		int result = 0;
		if(nums.length < 3) return result;
		Arrays.sort(nums);
		for(int i=2;i<nums.length;i++) {
			int left = 0, right = i-1;
			while(left < right) {
				if (nums[left] + nums[right] > nums[i]) {
					result += (right -left);
					right --;
				}else {
					left ++;
				}
			}
		}
		return result;
	}
//	ArrayList<List> result = new ArrayList();
//	public int triangleNumber(int[] nums) {
//	 ArrayList<Integer> tmp = new ArrayList<Integer>();
//	 helper(tmp, nums,0);
//	 System.out.println(result);
//	 return result.size();
//        
//    }
//	public void helper(List<Integer> tmp, int[] nums, int position) {
//
//		if(tmp.size()==3 && valid_triangle(tmp)) {
//			result.add(new ArrayList(tmp));
//		}
//		if (position >=nums.length) {
//			return;
//		}
//		
//		for(int i=position;i<nums.length;i++) {
//			tmp.add(nums[i]);
//			helper(tmp, nums,i+1);
//			tmp.remove(tmp.size()-1);
//		}
//		
//		
//	}
//	
//	public boolean valid_triangle(List<Integer> nums) {
//		System.out.println(nums);
//		int a = nums.get(0);
//		int b = nums.get(1);
//		int c = nums.get(2);
//		
//		if(a + b > c && a+c > b && b+c >a && Math.abs(a-b) < c && Math.abs(a-c)<b && Math.abs(b-c)<a ) {
//			return true;
//		}else {
//			return false;
//		}
//	}
	public static void main(String[] args) {
		Solution_611 s = new Solution_611();
		int[] nums = new int[] {0,1,1,1};
		System.out.println(s.triangleNumber(nums));
				
	}

}
