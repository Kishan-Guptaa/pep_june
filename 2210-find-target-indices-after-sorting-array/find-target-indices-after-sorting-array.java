class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // Arrays.sort(nums);
        // List<Integer>ans = new ArrayList<>();
        // for(int i=0; i<nums.length; i++){
        //     if(nums[i] == target){
        //         ans.add(i);
        //     }
        // }
        // return ans;
        int small = 0;
        int equal = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < target){
                small++;
            }
            else if(nums[i] == target){
                equal++;
            }
        }
        List<Integer>ans = new ArrayList<>();
        for(int i=0; i<equal; i++){
            ans.add(small + i);
        }
        return ans;
    }
}