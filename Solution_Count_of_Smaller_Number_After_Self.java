package leetcode_top100;

import java.util.ArrayList;
import java.util.List;

public class Solution_Count_of_Smaller_Number_After_Self {
	// 找到当前位置上比小的数， 如果当前位置的数比前一个大，则小的数就是和前一个一样。
	// 与找逆序对数类型题相似， 是他的一个变形，
	int [] count;
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		count = new int[nums.length];
		int[] indexes = new int[nums.length];
		
		// 按顺序排序的时候，需要记录当前数字的下标
		for(int i=0;i<nums.length;i++) {
			indexes[i] = i;
		}
		mergesort(nums, indexes, 0, nums.length-1);  //归并排序
		for(int i=0;i<count.length; i++) {
			res.add(count[i]);
		}
		return res;
        
    }
	private void mergesort(int[] nums, int[] indexes, int start, int end) {
		if( end <= start) {
			return;
		}
		int mid = (start + end) /2;
		mergesort(nums, indexes, start, mid); // 左边已经排序完毕
		mergesort(nums, indexes, mid+1, end); // 右边已经排序完毕
		merge(nums, indexes, start,end); // merge过程中计算的cross的
	}
	
	private void merge(int[] nums, int[] indexes, int start, int end) {
		int mid = (start + end) /2;
		int left_index = start;
		int right_index = mid+1;
		int rightcount = 0;
		int [] new_indexes = new int[end-start + 1];
		int sort_index = 0;
		while(left_index <= mid && right_index <=end) {
			if(nums[indexes[right_index]] < nums[indexes[left_index]]) {
				new_indexes[sort_index]  = indexes[right_index];
				rightcount ++;
				right_index ++;
			}else {
				new_indexes[sort_index] = indexes[left_index];
				count[indexes[left_index]] += rightcount;
				left_index ++;
			}
			sort_index ++;
			
		}
		
		while(left_index <= mid) {
			new_indexes[sort_index] = indexes[left_index];
			count[indexes[left_index]] += rightcount;
			left_index ++;
			sort_index ++;
		}
		while(right_index <= end) {
			new_indexes[sort_index++] = indexes[right_index++];
		}
		for(int i=start; i<= end;i++){
			indexes[i] = new_indexes[i-start];
		}
		
		
	}
	
}
