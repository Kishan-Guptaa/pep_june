class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        TreeSet<Integer>set = new TreeSet<>(Collections.reverseOrder());
        for(int num : nums){
            set.add(num);
        }
        int size = Math.min(k, set.size());
        int[] ans = new int[size];

        int i = 0;
        for(int num : set){
            if(i == k){
                break;
            }
            ans[i++] = num;
            
        }
        return ans;
    }
}