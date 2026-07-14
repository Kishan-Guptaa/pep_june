class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
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
        return dfs(source, destination, visited, graph);
    }

    private boolean dfs(int src, int des, boolean[] visited, List<Integer>[] graph){
        if(src == des){
            return true;
        }
        visited[src] = true;
        for(int next : graph[src]){
            if(!visited[next]){
                if(dfs(next, des, visited, graph)){
                    return true;
                }
            }
        }

        return false;
    }
}