class Solution {
    private int dfs(int node, List<int[]>[] graph, boolean[] visited){
        visited[node] = true;
        int change = 0;
        for(int[] nei : graph[node]){
            int nextNode = nei[0];
            int cost = nei[1];
            if(!visited[nextNode]){
                change += cost;
                change += dfs(nextNode, graph, visited);
            }
        }

        return change;
    }
    public int minReorder(int n, int[][] connections) {
        List<int[]>[]graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] it : connections){
            int u = it[0];
            int v = it[1];
            graph[u].add(new int[]{v,1});
            graph[v].add(new int[]{u,0});
        }

        boolean[] visited = new boolean[n];

        return dfs(0, graph, visited);

    }
}