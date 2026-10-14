class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int maxValue = 0;
        for(int num : map.values()){
            maxValue = Math.max(maxValue, num);
        }
        int sum = 0;
        for(int freq : map.values()){
            if(freq == maxValue){
                sum += freq;
            }
        }
        return sum;
    }
}