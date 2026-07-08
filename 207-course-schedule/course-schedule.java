class Solution {
    private int[]  topoSort(int n, List<Integer>[] adj ){
        int[] indegree = new int[n];
        for(int i=0; i<n; i++){
            for(int it : adj[i]){
                indegree[it]++;
            }
        }

        Queue<Integer>q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int[] ans = new int[n];
        int idx = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            ans[idx++] = node;
            for(int it : adj[node]){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
            
        }

        return Arrays.copyOfRange(ans, 0, idx);
    }
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] it : prerequisites){
            int u = it[0];
            int v = it[1];
            adj[u].add(v);
        }

        int[] topo = topoSort(n, adj);
        if(topo.length < n){
            return false;
        }
        return true;
    }
}