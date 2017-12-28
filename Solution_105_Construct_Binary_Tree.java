package leetcode_top100;

public class Solution_105_Construct_Binary_Tree {
	// 本题的意思是给了一棵树的前序 和中序遍历，然后构造这个树
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return subTree(0,0,inorder.length-1,preorder, inorder);
    }
	public TreeNode subTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if(preStart > preorder.length-1 || inStart > inEnd) return null;
		
		TreeNode root = new TreeNode(preorder[preStart]);
		int index = 0;
		for(int i=inStart;i<=inEnd;i++) {
			if (inorder[i] == root.val) {
				index = i;
				break;
				
			}
		}
		TreeNode left = subTree(preStart + 1, inStart, index-1, preorder, inorder);
		TreeNode right = subTree(preStart + index -inStart + 1, index + 1, inEnd, preorder, inorder);
		root.left = left;
		root.right = right;
		return root;
		
	}

}
