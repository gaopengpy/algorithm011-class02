class Solution {
    public void moveZeroes(int[] nums) {

		if (nums == null) {
			return;
		}

		if (nums.length <= 1) {
			return;
		}

        int temp = 0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
  
                if(nums[i]==0){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

    }
}
