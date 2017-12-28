package leetcode_top100;

public class Solution_First_Missing_Positive {
	   //找到第一missing 的正数， 要求时间复杂度为O(N) 且O(1) 的空间复杂度
	   // 这是一个没排序的组合 ， 若排序后寻找  时间复杂度是O(nlogn)
	
	  // 注意的是 我们要找的是少的第一个正数， 所以如果有k 个正数， 那么少的那个positive 必在[1,k+1]之间
	
	
		// 由于不能使用额外的空间，那就只能利用数组本身，利用数组的index 作为数字本身的索引，把正数按照递增顺序依次放到数组中， 
		// 使得第i位上存储数值 (i+1)， 最后遍历数组，找到第一个不符合要求的元素，返回其下标
	
		
	 	public int firstMissingPositive(int[] nums) {
	 		if (nums == null || nums.length == 0) {
	 			return 1;
	 		}
	 		// 遵循条件  nums[i] = i + 1的原则
 	 		
	 		for( int i=0;i< nums.length;i++) {
	 			
	 			if(nums[i] <= nums.length && nums[i] > 0 && nums[nums[i]-1] != nums[i]) { // 循环时候注意死循环
	 				int temp = nums[nums[i] -1];
	 				nums[nums[i]-1] = nums[i];
	 				nums[i] = temp;  // 将nums[i] 放置到他应该到的位置上去 ，即位置nums[i]-1;
	 				i--; //刚被换过来的数也需要处理一下
	 			}
	 		}
	 		for( int i=0;i<nums.length;i++) {
	 			if(nums[i] != i+1) {
	 				return i+1;
	 			}
	 			
	 		}
	 		return nums.length + 1;
	        
	    }
	 	
	 	
}
