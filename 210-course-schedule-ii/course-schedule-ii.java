class Solution {
    private int[] topoSort(int V, List<List<Integer>>adj){
        int[] indegree = new int[V];
        for(int i=0; i<V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer>q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int[] ans = new int[V];
        int index = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            ans[index++] = node;
            for(int neighbor : adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
        if(index != V){
            return new int[0];
        }
        return ans;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];

            adj.get(v).add(u);
        }

        int[] topo = topoSort(numCourses, adj);
        return topo;
    }
}