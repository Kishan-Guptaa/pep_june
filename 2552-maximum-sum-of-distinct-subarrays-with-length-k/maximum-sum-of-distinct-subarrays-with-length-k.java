class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer>map = new HashMap<>();
        long sum = 0;
        long ans = 0;
        for(int i=0; i<k; i++){
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        if(map.size() == k){
            ans = sum;
        }

        for(int right = k; right < nums.length; right++){
            sum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            int leftEle = nums[right - k];
            sum -= leftEle;
            map.put(leftEle,map.get(leftEle) - 1);
            if(map.get(leftEle) == 0){
                map.remove(leftEle);
            }
            if(map.size() == k){
                ans = Math.max(ans,sum);
            }
        }
        return ans;
    }
}