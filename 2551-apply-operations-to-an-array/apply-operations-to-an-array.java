class Solution {
    public int[] applyOperations(int[] nums) {
        int left = 0;
        int right = left + 1;
        while(left < nums.length &&  right < nums.length){
            if(nums[left] == nums[right]){
                nums[left] = nums[left] * 2;
                nums[right] = 0;
            }
            left++;
            right++;
        }
        left = 0;
        right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }

        return nums;
    }
}