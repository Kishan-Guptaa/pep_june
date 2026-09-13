class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for(int i=0; i<n; i++){
            if(ans[i] != -1){
                continue;
            }
            Queue<Integer>q = new LinkedList<>();
            q.add(i);
            ans[i] = 0;
            while(!q.isEmpty()){
                int node = q.poll();
                for(int neighbour : graph[node]){
                    if(ans[neighbour] == -1){
                        ans[neighbour] = 1 - ans[node];
                        q.add(neighbour);
                    }
                    else if(ans[neighbour] == ans[node]){
                        return false;
                    }
                }

            }
        }
        return true;
    }
}