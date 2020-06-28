class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
		// 从后向前插入，
		// l 表示从后向前当前插入位置
		int l = m + n - 1;
		// i 标记数组 nums1 当前比较位置
		int i = m - 1;
		// j 标记数组 nums2 当前比较位置
		int j = n - 1;
		// 将数组 nums 2 全部数据插入到数组 nums1 为止
		while (j >= 0) {
			// 当数组 nums1 当前可比较数据位 i 大于等于 0 并且数组 nums1 当前位置值比 nums2 当前位置值大时，将数组 nums1 当前位置数组
			// 插入到 l 位置 ，i 位指针向前挪一位
			// 否则将 nums2 当前位置数据插入到 l 位置，j 位指针向前挪一位
			// 当前插入位置 l 向前挪一位
			nums1[l--] = (i >= 0 && nums1[i] >= nums2[j]) ? nums1[l] = nums1[i--] : nums2[j--];
		}
    
    }
}
