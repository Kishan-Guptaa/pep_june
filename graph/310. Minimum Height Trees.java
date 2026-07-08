// https://leetcode.com/problems/minimum-height-trees/description/?envType=problem-list-v2&envId=graph

class Solution {
    private List<Integer> topoSort(int n, List<Integer>[] adj){
        int[] indegree = new int[n];
        for(int i=0; i<n; i++){
            indegree[i] = adj[i].size();
        }

        Queue<Integer>q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 1){
                q.add(i);
            }
        }

        int remainingNode = n;
        while(remainingNode > 2){
            int size = q.size();
            remainingNode -= size;
            for(int i=0; i<size; i++){
                int leaf = q.remove();
                for(int neighbors : adj[leaf]){
                    indegree[neighbors]--;
                    if(indegree[neighbors] == 1){
                        q.add(neighbors);
                    }
                }
            }
        }

        List<Integer>ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.remove());
        }

        return ans;
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return Arrays.asList(0);
        }

        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] it : edges){
            int u = it[0];
            int v = it[1];
            adj[u].add(v);
            adj[v].add(u);

        }

        return topoSort(n, adj);
    }
}