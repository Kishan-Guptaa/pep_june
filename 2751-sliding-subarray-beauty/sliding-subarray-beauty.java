class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int[] freq = new int[101];
        for(int i=0; i<k; i++){
            freq[nums[i] + 50]++;
        }
        int ansIndex = 0;
        for(int right = k; right <= n; right++){
            int beauty = 0;
            int count = 0;
            for(int i=0; i<50; i++){
                count += freq[i];
                if(count >= x){
                    beauty = i - 50;
                    break;
                }
            }
            ans[ansIndex] = beauty;
            ansIndex++;

            if(right < n){
                freq[nums[right - k] + 50]--;
                freq[nums[right] + 50]++;
            }
        }
        return ans;
    }
}