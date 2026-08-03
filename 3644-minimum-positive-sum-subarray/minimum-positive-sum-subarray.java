class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n && j< i + r; j++){
                sum += nums.get(j);
                int len = j - i + 1;
                if(len >= l && sum > 0){
                    ans = Math.min(sum, ans);
                }
            }
        }

        if(ans == Integer.MAX_VALUE){
            return -1;
        }

        return ans;
    }
}