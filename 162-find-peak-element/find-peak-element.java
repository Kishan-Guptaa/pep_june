class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            if(i > 0 && nums[i] <= nums[i-1]){
                continue;
            }
            if(i < n-1 && nums[i] <= nums[i+1]){
                continue;
            }
            return i;
        }
        return -1;
    }
}