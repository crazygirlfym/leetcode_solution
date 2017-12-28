package leetcode_top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_102Binary_Tree_Level_Order_Traversal {
	// 层次遍历, 在层次遍历的过程中，可以加入"#"特殊的符号，（但是在java中需要定义类型）， 区分这个层次是否结束。
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> stack = new LinkedList<TreeNode>();
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
				result.add(new ArrayList(tmp));
				
				tmp = new ArrayList<Integer>();
				
				stack.add(null);
				
			}		
		}
		result.add(new ArrayList(tmp));
		System.out.println(result);
		return result;   
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode l1 = new TreeNode(9);
		TreeNode r1 = new TreeNode(20);
		root.left = l1;
		root.right = r1;
		
		TreeNode l2 = new TreeNode(15);
		TreeNode r2 = new TreeNode(7);
		r1.left = l2;
		r1.right = r2;
		Solution_102Binary_Tree_Level_Order_Traversal s = new Solution_102Binary_Tree_Level_Order_Traversal();
		s.levelOrder(root);
		
		
	}
}
