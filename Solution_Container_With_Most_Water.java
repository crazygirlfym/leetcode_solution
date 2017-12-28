package leetcode_top100;

public class Solution_Container_With_Most_Water {
	// 横坐标是想减，需要选择两个长板中的短板，至多用O(n^2)的时间能处理
	// 如果用一个左右指针，滑动窗口的方法呢?
	
	public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int result = 0;
        while(left < right) {
        		int area = Math.min(height[left], height[right]) * (right-left);
        		result = Math.max(result, area);
        		// 解决如何滑动的问题
        		if(height[left] < height[right]) {
        			left ++;
        		} else {
        			right --;
        		}
        		  
        }
        return result;
    }
}
