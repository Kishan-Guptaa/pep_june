class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            if(nums[left] > 0){
                return -1;
            }
            int value = Math.abs(nums[left]);
            if(value == nums[right]){
                return value;
            }
            else if(value < nums[right]){
                right--;
            }
            else{
                left++;
            }

        }
        return -1;
    }
}