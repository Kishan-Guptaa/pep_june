class Solution {
    int[] prev;
    int[] dp;
    int n;
    int k;
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        this.n = n;
        this.k = k;
        prev = new int[n];
        for(int[] r : relations){
            int u = r[0] - 1;
            int v = r[1] - 1;
            prev[v] |= (1 << u);
        }
        int size = (1 << n);
        dp = new int[size];
        Arrays.fill(dp, -1);
        return dfs(0);
    }
    private int dfs(int mask){
        if(mask == (1 << n) - 1){
            return 0;
        }

        if(dp[mask] != -1){
            return dp[mask];
        }
        int available = 0;
        for(int i=0; i<n; i++){
            if((mask & (1 << i)) == 0){
                if((mask & prev[i] )== prev[i]){
                    available |= (1 << i);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        if(Integer.bitCount(available) <= k){
            ans = 1 + dfs(mask | available);
        }
        else{
            for(int sub = available; sub > 0 ; sub = (sub-1) & available){
                if(Integer.bitCount(sub) == k){
                    ans = Math.min(ans, 1 + dfs(mask | sub));
                }
            }
        }
        return dp[mask] = ans;
    }
}