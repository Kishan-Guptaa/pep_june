class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int left = 0;
        int right = 0;
        int ans = 0;
        while(left < nums1.length && right < nums2.length){
            if(left <= right && nums1[left] <= nums2[right]){
                ans = Math.max(ans, right - left);
                right++;
            }
            else{
                left++;
                if(left > right){
                    right = left;
                }
                
            }
            
        }
        return ans;
    }
}