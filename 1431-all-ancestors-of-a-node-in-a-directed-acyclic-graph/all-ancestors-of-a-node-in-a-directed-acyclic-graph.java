class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            indegree[v]++;
        }


        TreeSet<Integer>[] ancestor = new TreeSet[n];
        for(int i=0; i<n; i++){
            ancestor[i] = new TreeSet<>();
        }

        Queue<Integer>q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : graph[u]){
                ancestor[v].add(u);
                ancestor[v].addAll(ancestor[u]);
                indegree[v]--;
                if(indegree[v] == 0){
                    q.add(v);
                }
            }
        }

        List<List<Integer>>ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            ans.add(new ArrayList<>(ancestor[i]));
        }

        return ans;
    }
}