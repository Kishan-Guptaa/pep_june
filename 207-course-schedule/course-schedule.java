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

        int[] topo = new int[V];
        int index = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo[index++] = node;
            for(int neighbor : adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
        return Arrays.copyOfRange(topo, 0, index);
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj = new ArrayList<>();
        // int n = prerequisites.length;
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];
            adj.get(u).add(v);
        }
        int[] topo = topoSort(numCourses, adj);
        if(topo.length < numCourses){
            return false;
        }
        return true;
    }
}