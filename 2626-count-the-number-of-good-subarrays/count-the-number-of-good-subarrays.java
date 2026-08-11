class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Long>map = new HashMap<>();
        long ans = 0;
        long pair = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            long count = map.getOrDefault(nums[right], 0L);
            pair += count;
            map.put(nums[right],count+1);
            while(pair >= k){
                ans += nums.length - right;
                long leftCount = map.get(nums[left]);
                map.put(nums[left], leftCount - 1);
                pair -= leftCount - 1;
                left++;
            }   

        }
        return ans;
    }
}