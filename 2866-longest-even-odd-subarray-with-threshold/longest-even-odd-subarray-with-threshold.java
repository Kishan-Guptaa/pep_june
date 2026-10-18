class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int len = 0;
        int maxLen = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > threshold){
                len = 0;
                continue;
            }
            if(len == 0){
                if(nums[i] % 2 == 0){
                    len = 1;
                    maxLen = Math.max(maxLen, len);
                }
            }
            else{
                if(nums[i] % 2 != nums[i-1] % 2){
                    len++;
                
                }
                else{
                    len = (nums[i] % 2 == 0) ? 1 : 0;
                }
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
    }
}