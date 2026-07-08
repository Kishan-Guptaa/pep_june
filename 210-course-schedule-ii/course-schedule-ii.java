class Solution {
    private int[] topoSort(int n, List<Integer>[]adj){
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
        int[] ans =  new int[n];
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

        if(idx != n){
            return new int[0];
        }
        return ans;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] it : prerequisites){
            int u = it[0];
            int v = it[1];
            adj[v].add(u);
        }
        return topoSort(numCourses, adj);
    }
}