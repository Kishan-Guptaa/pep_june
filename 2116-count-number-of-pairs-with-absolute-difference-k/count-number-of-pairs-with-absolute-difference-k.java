class Solution {
    public int countKDifference(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(Math.abs(nums[i] - nums[j]) == k){
                    sum++;
                }
            }
        }
        return sum;
    }
}