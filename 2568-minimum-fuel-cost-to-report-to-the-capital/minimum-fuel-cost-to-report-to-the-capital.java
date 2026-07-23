class Solution {
    long fuel = 0;
    private int dfs(int node, int parent, List<Integer>[]graph, int seats){
        int people = 1;
        for(int neighbours : graph[node]){
            if(neighbours == parent){
                continue;
            }

            people += dfs(neighbours, node, graph, seats);
        }
        if(node != 0){
            fuel += (people + seats - 1) / seats;
        }
        return people;
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] road : roads){
            int u = road[0];
            int v = road[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(0, -1, graph, seats);

        return fuel;
    }
}