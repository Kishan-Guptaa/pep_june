class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        int ans = 0;
        while(left <= right){
            int value = nums[left] + nums[right];
            ans = Math.max(ans, value);
            left++;
            right--;
        }
        return ans;
    }
}