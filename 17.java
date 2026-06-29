https://leetcode.com/problems/koko-eating-bananas


class Solution {
    private int findMax(int[] piles){
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            ans = Math.max(ans,piles[i]);
        }
        return ans;
    }
    private long calculate(int[] piles, int target){
        int n = piles.length;
        long totalH = 0;
        for(int i=0; i<n; i++){
            totalH += Math.ceil((double)piles[i]/(double)target);
        }
        return totalH;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);
        while(low <= high){
            int mid = (low + high) / 2;
            long totalH = calculate(piles,mid);
            if(totalH<=h){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}