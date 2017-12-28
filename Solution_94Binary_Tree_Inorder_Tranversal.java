package leetcode_top100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class Solution_94Binary_Tree_Inorder_Tranversal {
	
	// 中序遍历
	ArrayList<Integer> result = new ArrayList<Integer>();
	
	public List<Integer> inorderTraversal(TreeNode root) {
		// 递归实现
//		iterRead(root);
//		
//		return result;
		return uniterRead(root);
        
    }
	//递归实现 
	public void iterRead(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			iterRead(root.left);
		}
		result.add(root.val);
		
		if(root.right != null) {
			iterRead(root.right);
		}
		
	}
	// 非递归实现, 借助栈实现
	
	public List<Integer> uniterRead(TreeNode root){
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			return null; 
		}
		TreeNode cur = root;
		while(cur != null || !stack.empty()) {
			while(cur != null) {
				stack.add(cur);
				cur = cur.left;
			}
			cur =stack.pop();
			res.add(cur.val);
			cur = cur.right;
		}
		
		return res;
	}
	
}
