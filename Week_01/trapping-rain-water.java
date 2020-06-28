class Solution {
    public int trap(int[] height) {

		if (height == null) {
			return 0;
		}

		int sum = 0;

		// 最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 1
		for (int i = 1; i < height.length - 1; i++) {

			// 找出左边最高
			int max_left = 0;
			for (int j = i - 1; j >= 0; j--) {
				max_left = Math.max(max_left, height[j]);
			}

			// 找出右边最高
			int max_right = 0;
			for (int k = i + 1; k < height.length; k++) {
				max_right = Math.max(max_right, height[k]);
			}

			// 找出两端较小的
			int min = Math.min(max_left, max_right);

			// 只有较小的一段大于当前列的高度才会有水，其他情况不会有水
			if (min > height[i]) {
				sum = sum + (min - height[i]);
			}

		}

		return sum;
	
    }
}
