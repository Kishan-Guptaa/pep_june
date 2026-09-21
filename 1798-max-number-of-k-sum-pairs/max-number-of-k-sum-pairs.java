class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer>map = new HashMap<>();
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            int val = k - nums[i];
            if(map.getOrDefault(val, 0) > 0){
                ans++;
                map.put(val, map.get(val) - 1);
            }
            else{
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return ans;
    }
}