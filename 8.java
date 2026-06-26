// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = firstOcc(nums, target);
        int last = lastOcc(nums, target);
        return new int[]{first, last};
    }
    private int firstOcc(int[] nums, int target){
        int n = nums.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        while(start<=end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                ans = mid;
                 end = mid - 1;
            }
            else if(nums[mid] >= target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }

    private int lastOcc(int[] nums, int target){
        int n = nums.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == target){
                ans = mid;
                start = mid + 1;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
}