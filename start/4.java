https://leetcode.com/problems/is-graph-bipartite/


class Solution {
    public boolean isBipartite(int[][] graph) {
        // List<List<Integer>>adj = new ArrayList<>();
        int V = graph.length;
        // for(int i=0; i<V; i++){
        //     adj.add(new ArrayList<>());
        // }

        // for(int[] edge : graph){
        //     int u = edge[0];
        //     int v = edge[1];

        //     adj.get(u).add(v);
        //     adj.get(v).add(u);
        // }

        int[] color = new int[V];
        Arrays.fill(color, -1);
        for(int i=0; i<V; i++){
            if(color[i] != -1){
                continue;
            }

            Queue<Integer>q = new LinkedList<>();
            q.add(i);
            color[i] = 0;

            while(!q.isEmpty()){
                int node = q.remove();

                for(int neighbour : graph[node]){
                    if(color[neighbour] == -1){
                        color[neighbour] = 1 - color[node];
                        q.add(neighbour);
                    }
                    else if(color[neighbour] == color[node]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}