class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i=0; i<clone.length; i++){
            if(!map.containsKey(clone[i])){
                map.put(clone[i], i);
            }
        }

        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i] = map.get(nums[i]);
        }
        return ans;
    }
}