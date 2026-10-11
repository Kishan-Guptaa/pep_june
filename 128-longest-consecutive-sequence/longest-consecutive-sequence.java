class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0 ){
            return 0;
        }
        HashSet<Integer>set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int longest = 0;
        for(int val : set){
            if(!set.contains(val - 1)){
                int count = 1;
                int x = val;
                while(set.contains(x+1)){
                    count++;
                    x++;
                }
                longest = Math.max(longest, count);
            }
            
        }
        return longest;
    }
}