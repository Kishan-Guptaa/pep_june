class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(helper(nums,firstLen, secondLen), helper(nums, secondLen, firstLen));
    }
    private int helper(int[] nums, int L , int M){
        int[] prefixSum = new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        int maxL = 0;
        int result = 0;
        for(int i = L+M; i<=nums.length; i++){
            int sumL = prefixSum[i-M] - prefixSum[i-M-L];
            maxL = Math.max(maxL, sumL);

            int SumM = prefixSum[i] - prefixSum[i-M];
            result = Math.max(result, SumM+maxL);
        }
        return result;
    }
}