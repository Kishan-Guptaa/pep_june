class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = k-1;
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        while(j < n){
            int diff = nums[j] - nums[i];
            ans = Math.min(ans, diff);
            i++;
            j++;
        }
        return ans;
    }
}