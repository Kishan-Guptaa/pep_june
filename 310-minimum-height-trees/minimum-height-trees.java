class Solution {
    private List<Integer>topoSort(int V, List<List<Integer>>adj){
        int[] indegree = new int[V];
        for(int i=0; i<V; i++){
            indegree[i] = adj.get(i).size();
        }

        Queue<Integer>q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i] == 1){
                q.add(i);
            }
        }

        int remainingNode = V;
        while(remainingNode > 2){
            int size = q.size();
            remainingNode -= size;
            for(int i=0; i<size; i++){
                int node = q.remove();
                for(int neighbor : adj.get(node)){
                    indegree[neighbor]--;
                    if(indegree[neighbor] == 1){
                        q.add(neighbor);
                    }
                }
            }
        }
        List<Integer>topo = new ArrayList<>();
        while(!q.isEmpty()){
            topo.add(q.poll());
        }
        return topo;
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return Arrays.asList(0);
        }
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return topoSort(n, adj); 
    }
}