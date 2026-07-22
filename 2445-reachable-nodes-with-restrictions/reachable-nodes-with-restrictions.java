class Solution {
    private int dfs(int start, boolean[] visited, boolean[] blocked, List<Integer>[] graph){
        if(blocked[start] || visited[start]){
            return 0;
        }
        
        visited[start] = true;
        int count = 1;
        for(int next : graph[start]){
            count += dfs(next, visited, blocked, graph);
        }
        return count;
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n;i ++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] blocked = new boolean[n];
        for(int block: restricted){
            blocked[block] = true;
        }

        boolean[] visited = new boolean[n];
        return dfs(0, visited, blocked, graph);
    }
}