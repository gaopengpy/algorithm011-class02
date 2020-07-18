使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

此题与Leetcode 153 寻找旋转排序数组中的最小值 题解题思路是一致的，只不过此题返回的是索引

解题思路：
1.如果数组长度为1，返回唯一的一个数

2.定义两个指针，第一个left指向数组开头，第二个right指向数组结尾

3.检查数组是否被翻转，如果没有，则返回数组里的第一个数

4.当left小于right时，取中间作为mid进行二分搜索，如果mid的左边一个数大于mid，或者mid的右边一个数小于mid，则返回mid

5.否则的话，如果left所在的数小于mid，则将left右移至mid+1的位置(砍掉左半边)

6.否则的话，将right左移至mid-1的位置(砍掉右半边)
  
   public static int findMinIndex(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        
        //说明是已经排好序的数组
        if (nums[right] > nums[0]) {
            return -1;  
        }
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid == 0) {
                return nums[0] < nums[1] ? nums[0] : nums[1];
            }

            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }

            if ((nums[mid] < nums[mid - 1])) {
                return mid;
            }

            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;
    }
