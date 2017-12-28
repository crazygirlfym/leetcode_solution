package leetcode_top100;

public class Solution_124Binary_Tree_Maximum_Path_Sum {
	// 节点中可能存在负数的情况需要考虑
	//
	
	int result = Integer.MAX_VALUE;
	public int maxPathSum(TreeNode root) {
        helper(root);
        return result;
    }
	
	public int helper(TreeNode root) {
		if (root ==null) return 0;
		int left = Math.max(0, helper(root.left));
		int right = Math.max(0, helper(root.right));
		result = Math.max(result, root.val + left + right); //最后的结果 同时也边计算
		return root.val + Math.max(left, right); // 返回的值 只返回左边或者右边 
		
	
	}
}
