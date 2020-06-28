class Solution {

     List<Integer> res = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
		if (root != null) {
			inorderTraversal(root.left);
			res.add(root.val);
			inorderTraversal(root.right);
		}
		return res;
    }
}
