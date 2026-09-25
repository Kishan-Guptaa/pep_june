class Solution {
    public int thirdMax(int[] nums) {
        long n1 = Long.MIN_VALUE;
        long n2 = Long.MIN_VALUE;
        long n3 = Long.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(n1 == nums[i] || n2 == nums[i] || n3 == nums[i]){
                continue;
            }
            if(nums[i] > n1){
                n3 = n2;
                n2 = n1;
                n1 = nums[i];
            }
            else if(nums[i] > n2){
                n3 = n2;
                n2 = nums[i];
            }
            else if(nums[i] > n3){
                n3 = nums[i];
            }
        }
         return n3 == Long.MIN_VALUE ? (int) n1 : (int) n3;
    }
}