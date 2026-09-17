class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        long sum = 0;
        while(left <= right){
            if(left == right){
                sum += nums[left];
                break;
            }
         long num = Integer.parseInt(String.valueOf(nums[left]) + String.valueOf(nums[right]));
            sum += num;
            left++;
            right--;
        }
        return sum;
    }
}