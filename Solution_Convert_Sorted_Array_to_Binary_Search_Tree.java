package leetcode_top100;

public class Solution_Convert_Sorted_Array_to_Binary_Search_Tree {
		// 将一个排序好的数组平衡的二叉搜索树
		// 如何保证平衡问题
		// 一棵搜索树的先序遍历就是一个排序的数组
	
	 	public TreeNode sortedArrayToBST(int[] nums) {
	        return buildTree(nums,0, nums.length-1);
	    }
	 	public TreeNode buildTree(int[]nums, int from , int to) {
	 		if(from == to) {
	 			return new TreeNode(nums[from]);
	 		}
	 		if (to < from) return null;
	 		int mid = (to-from)/2 + from;
	 		TreeNode root = new TreeNode(nums[mid]);
	 		root.left = buildTree(nums,from, mid-1);
	 		root.right = buildTree(nums, mid+1, to);
	 		return root;
	 		
	 	}
}
