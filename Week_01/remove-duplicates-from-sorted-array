class Solution {
    public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            //快慢指针法，i是慢指针，j是快指针
            //当i指针的值不等于j指针的值
            //i往前走，将j的值赋值给i,j继续往后移动
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if(nums[j]!=nums[i]){
                    i++;
                    nums[i]=nums[j];
                }
           
            }
            return i + 1;
    }
}
