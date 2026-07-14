class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] like : dislikes){
            int u = like[0];
            int v = like[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] ans = new int[n+1];
        Arrays.fill(ans,-1);
        Queue<Integer>q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(ans[i] != -1){
                continue;
            }

            ans[i] = 0;
            q.add(i);

            while(!q.isEmpty()){
                int node = q.poll();
                for(int next : adj.get(node)){
                    if(ans[next] == -1){
                        ans[next] = 1 - ans[node];
                        q.add(next);
                    }
                    else if(ans[next] == ans[node]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}