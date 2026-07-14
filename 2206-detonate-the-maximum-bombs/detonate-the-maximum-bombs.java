class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long radi = bombs[i][2];

            for(int j=0; j<n; j++){
                if(i == j){
                    continue;
                }

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                long dx = x1 - x2;
                long dy = y1 - y2;

                long distsq = dx * dx + dy * dy;
                if(distsq <= radi * radi){
                    graph[i].add(j);
                }
            }
        }

        int ans = 1;
        for(int i=0; i<n; i++){
            boolean[] vis = new boolean[n];
            ans = Math.max(ans, dfs(i, graph, vis));
        }

        return ans;

    }

    private int dfs(int node, List<Integer>[] graph, boolean[] vis){
        vis[node] = true;
        int count = 1;
        for(int next : graph[node]){
            if(!vis[next]){
                count += dfs(next, graph, vis);
            }
        }

        return count;
    }
}