class Solution {
    public int minimumDeletions(int[] nums) {
        int minIndex = 0;
        int maxIndex = 0;
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(maxValue < nums[i]){
                maxValue = nums[i];
                maxIndex = i;
            }
            if(minValue > nums[i]){
                minValue = nums[i];
                minIndex = i;
            }
        }
        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);
        int op1 = right + 1;
        int op2 = nums.length - left;
        int op3 = (left + 1) + (nums.length - right);

        return Math.min(op1, Math.min(op2, op3));

    }
}