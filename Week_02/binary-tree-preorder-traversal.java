class Solution {
    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
		if (root != null) {
			res.add(root.val);
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
		return res;
    }
}