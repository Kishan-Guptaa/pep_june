// https://leetcode.com/problems/find-eventual-safe-states/


class Solution {
    private boolean dfs(int node, int[][] graph, boolean[] vis, boolean[] pathVis, boolean[] check){
        vis[node] = true;
        pathVis[node] = true;
        check[node] = false;

        for(int it : graph[node]){
            if(!vis[it]){
                if(dfs(it, graph, vis, pathVis, check)){
                    return true;
                }
            }
            else if(pathVis[it]){
                return true;
            }
        }

        check[node] = true;
        pathVis[node] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        boolean[] check = new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]){
                dfs(i, graph, vis, pathVis, check);
            }
        }
        List<Integer>ans = new ArrayList<>();
        for(int i=0; i<n; i++){
           if(check[i]){
            ans.add(i);
           }
        }
        return ans;
    }
}