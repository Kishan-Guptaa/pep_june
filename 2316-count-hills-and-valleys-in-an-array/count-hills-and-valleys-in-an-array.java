class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        for(int i=1; i<nums.length-1; i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            int left = nums[i-1];
            int right = nums[i+1];

            int j = i+1;
            while(j < nums.length && nums[i] == nums[j]){
                j++;
            }
            if (j == nums.length) {
                continue;
            }
            right = nums[j];
            if((nums[i] > left && nums[i] > right )|| (nums[i] < left && nums[i] < right)){
                count++;
            }
        }
        return count;
    }
}