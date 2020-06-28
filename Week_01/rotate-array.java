class Solution {
    public void rotate(int[] nums, int k) {
		int step = k % nums.length; // 计算步长
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			hashMap.put((i + step) % nums.length, nums[i]);
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = hashMap.get(i);
		}
    }
}
