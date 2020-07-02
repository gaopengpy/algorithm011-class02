class Solution {
    public int[] topKFrequent(int[] nums, int k) {


		// 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int n : nums) {
			count.put(n, count.getOrDefault(n, 0) + 1);
		}

		System.out.println(count);

		// 遍历map，用最小堆保存频率最大的k个元素
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return count.get(a) - count.get(b);
			}

		});

		for (int key : count.keySet()) {

			if (heap.size() < k) {
				heap.add(key);
			} else if (count.get(key) > count.get(heap.peek())) {
				heap.remove();
				heap.add(key);
			}

		}

		// 取出最小堆中的元素
		List<Integer> res = new ArrayList<>();
		while (!heap.isEmpty()) {
			res.add(heap.remove());
		}

		int[] result = new int[res.size()];
		int i = 0;
		for (Integer e : res) {
			result[i++] = e;
		}

		return result;	
	
    }
}