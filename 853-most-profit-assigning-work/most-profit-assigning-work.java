class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for(int i=0; i<n; i++){
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs,(a,b) -> a[0] - b[0]);

        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, jobs[i][1]);
            jobs[i][1] = max;
        }

        int ans = 0;
        for(int ability : worker){
            ans += findProfit(jobs, ability);
        }
        return ans;
    }
    private int findProfit(int[][] jobs, int ability){
        int n = jobs.length;
        int left = 0;
        int right = n-1;
        int result = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(jobs[mid][0] <= ability){
                result = jobs[mid][1];
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return result;
    }
}