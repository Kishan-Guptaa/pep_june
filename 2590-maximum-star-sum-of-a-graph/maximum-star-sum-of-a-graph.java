class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph[u].add(vals[v]);
            graph[v].add(vals[u]);
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            Collections.sort(graph[i],Collections.reverseOrder());
            int sum = vals[i];
            for(int j=0; j<Math.min(k, graph[i].size()); j++){
                if(graph[i].get(j) <= 0){
                    break;
                }
                sum += graph[i].get(j);
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}