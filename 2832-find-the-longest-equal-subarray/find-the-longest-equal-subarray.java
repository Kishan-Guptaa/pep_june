class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        int left = 0;
        int ans = 0;
        HashMap<Integer, Integer>map = new HashMap<>();
        int maxfreq = 0;
        for(int right = 0; right < n; right++){
            map.put(nums.get(right), map.getOrDefault(nums.get(right), 0) + 1);
            maxfreq = Math.max(maxfreq, map.get(nums.get(right)));

            if((right - left + 1) - maxfreq > k){
                map.put(nums.get(left), map.get(nums.get(left)) - 1);
                left++;
            }

            ans = Math.max(ans, maxfreq);
        }
        return ans;

    }
}