class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				Node curr = queue.poll();
				level.add(curr.val);
				List<Node> children = curr.children;
				for (Node child : children) {
					if (child != null) {
						queue.add(child);
					}
				}
			}
			result.add(level);
		}

		return result;
    }
}