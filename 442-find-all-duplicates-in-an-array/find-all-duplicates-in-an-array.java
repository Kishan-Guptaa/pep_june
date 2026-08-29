class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>ans = new ArrayList<>();
        for (int num : map.keySet()) {
            if (map.get(num) == 2) {
                ans.add(num);
            }
        }
        return ans;
    }
}