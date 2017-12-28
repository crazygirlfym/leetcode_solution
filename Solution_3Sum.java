package leetcode_top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Solution_3Sum {
	// 可以转化为 two-sum问题, target为第三个数的负数
	// 本题中的nums 并不是unique num
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		// 将nums排序，时间复杂度为O(nlogn)
		
		Arrays.sort(nums);
		
		for(int i=0; i+2 <nums.length;i++) {
			if(i>0 && nums[i] == nums[i-1]) {
				continue;  //判断是否重复，如果直接利用内置的contains函数判断会超时
			}
			
			int j = i+ 1, k = nums.length-1;
			int target = -nums[i];  //转化为two sum问题
			while(j<k) {
				if (nums[j] + nums[k] == target) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j ++ ;
					k --;
					while(j < k && nums[j] ==nums[j-1]) j++; // 去重
					while(j < k && nums[k] == nums[k+1]) k--; //去重
					
				}else if(nums[j] + nums[k] > target) k--;
				else j++;
			}
			
			
		}
		
		return result;
        
    }
}
