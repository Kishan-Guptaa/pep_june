class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        return solve(nums, 0, 1, 1, target);
    }
    private boolean solve(int[] nums, int index, long productA, long productB, long target){
        if(index == nums.length){
            return productA == target && productB == target;
        }

        if(solve(nums, index+1, productA * nums[index], productB, target)){
            return true;
        }

        if(solve(nums,index+1, productA, productB * nums[index], target)){
            return true;
        }
        return false;
    }
}