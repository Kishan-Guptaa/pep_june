class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer>map = new TreeMap<>();
        int left = 0;
        int maxLength = 0;
        for(int right = 0; right < nums.length; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.lastKey() - map.firstKey() > limit){
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                    left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
  
}
// class Solution {
//     public int longestSubarray(int[] nums, int limit) {
//         int left = 0;
//         int maxLength = 0;
//         for(int right = 0; right < nums.length; right++){
//             while(max(nums,left, right) - min(nums, left, right) > limit){
//                 left++;
//             }
//             maxLength = Math.max(maxLength, right - left + 1);
//         }
//         return maxLength;
//     }
//     private int max(int[]nums, int left, int right){
//         int max = nums[left];
//         for(int i=left; i<=right; i++){
//             max = Math.max(max, nums[i]);
//         }
//         return max;

//     }

//     private int min(int[] nums, int left, int right){
//         int min = nums[left];
//         for(int i=left; i <= right; i++){
//             min = Math.min(min, nums[i]);
//         }
//         return min;
//     }
// }