class Solution {
    public double minimumAverage(int[] nums) {
        
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        double ans = Double.MAX_VALUE;

        while(left < right){
            double value = (nums[left] + nums[right]) / 2.0;
           
           ans = Math.min(ans, value);
           left++;
           right--;
        }
        return ans;
    }
}