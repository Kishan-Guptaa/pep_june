class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] indegree = new int[n];
        boolean[][] connected = new boolean[n][n];
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];

            indegree[u]++;
            indegree[v]++;

            connected[u][v] = true;
            connected[v][u] = true;
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int ans1  = indegree[i] + indegree[j];
                if(connected[i][j]){
                    ans1--;
                }
                ans = Math.max(ans,ans1);
            }
        }
        return ans;
    }
}