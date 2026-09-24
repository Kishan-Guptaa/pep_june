class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
       int[] prefix = new int[n];
       int[] suffix = new int[n];
       for(int i=1; i<n; i++){
        prefix[i] = nums[i-1] + prefix[i-1];
       }
       for(int i=n-2; i>=0; i--){
        suffix[i] = nums[i+1] + suffix[i+1];
       }
       for(int i=0; i<n; i++){
        if(prefix[i] == suffix[i]){
            return i;
        }
       }
       return -1;
    }
}
// class Solution {
//     public int pivotIndex(int[] nums) {
//         int totalSum = 0;
//         for(int i=0; i<nums.length; i++){
//             totalSum += nums[i];
//         }
//         int left = 0;
//         for(int i=0; i<nums.length; i++){
//             int right = totalSum - left - nums[i];
//             if(right == left){
//                 return i;
//             }
//             left += nums[i];
//         }
//         return -1;
//     }
// }