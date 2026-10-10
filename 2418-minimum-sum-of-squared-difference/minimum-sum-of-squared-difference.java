class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long total = 0;
        int max = 0;
        int sumVal = k1 + k2;
        int[] nums = new int[n];

        for(int i=0; i<n; i++){
            nums[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, nums[i]);
            total += nums[i];
        }

        if(total <= sumVal){
            return 0;
        }

        int[] freq = new int[max + 1];
        for(int x : nums){
            freq[x]++;
        }

        for(int i=max; i>0 && sumVal > 0; i--){
            if(freq[i] == 0){
                continue;
            }

            int count = Math.min(freq[i], sumVal);
            freq[i] -= count;
            freq[i - 1] += count;
            sumVal -= count;
        }

        long ans = 0;
        for(int i=0; i<freq.length; i++){
            ans += (long) i * i * freq[i];
        }
        return ans;

        
    }
}