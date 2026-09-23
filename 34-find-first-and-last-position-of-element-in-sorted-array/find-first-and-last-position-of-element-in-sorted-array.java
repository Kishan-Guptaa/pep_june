class Solution {
    public int[] searchRange(int[] nums, int target) {
        int pre = -1;
        int suc = -1;
        int left = 0;
        int right =  nums.length-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                pre = mid;
                right = mid - 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                suc = mid;
                left = mid + 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;

            }
            else{
                right = mid - 1;
            }
        }
        return new int[]{pre, suc};
    }
}