package leetcode_top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_103Binary_Tree_Zigzag_Level_Order_Traversal {
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) return result;
		Queue<TreeNode> stack = new LinkedList<TreeNode>();
		boolean left = true;
//		TreeNode special = new TreeNode("#");
		stack.add(root);
		stack.add(null);
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		TreeNode cur;
		
		while(stack.size() >1) {
			cur = stack.poll();
			if (cur != null) {
				tmp.add(cur.val);
				
				if (cur.left != null) {
					stack.add(cur.left);
				}
				if (cur.right !=null) {
					stack.add(cur.right);
				}
			}else {
				if(left == true) {
				result.add(new ArrayList(tmp));
				left = false;
				}else {
					ArrayList<Integer> tmp2 = new ArrayList<Integer>();
					for(int i=tmp.size()-1; i>=0 ;i--) {
						tmp2.add(tmp.get(i));
					}
					result.add(new ArrayList(tmp2));
					left = true;
				}
				
				tmp = new ArrayList<Integer>();
				
				stack.add(null);
				
			}		
		}
		if (left ==true) {
		result.add(new ArrayList(tmp));
		} else {
			ArrayList<Integer> tmp2 = new ArrayList<Integer>();
			for(int i=tmp.size()-1; i>=0 ;i--) {
				tmp2.add(tmp.get(i));
			}
			result.add(new ArrayList(tmp2));
		}
		System.out.println(result);
		return result;   
    }
}
