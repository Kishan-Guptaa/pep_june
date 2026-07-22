class Solution {
    private long dfs(int node, List<Integer>[]graph, boolean[] visited){
        visited[node] = true;
        long size = 1;
        for(int next : graph[node]){
            if(!visited[next]){
                size += dfs(next,graph,visited);
            }
        }
        return size;
    }
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];
        long processed = 0;
        long ans = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                long size = dfs(i, graph, visited);
                ans += processed * size;
                processed += size;
            }
        }
        return ans;
    }
}