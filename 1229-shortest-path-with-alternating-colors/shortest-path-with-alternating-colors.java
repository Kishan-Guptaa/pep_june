class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] graph1 = new ArrayList[n];
        List<Integer>[] graph2 = new ArrayList[n];

        for(int i=0; i<n; i++){
            graph1[i] = new ArrayList<>();
            graph2[i] = new ArrayList<>();
        }

        for(int[] e : redEdges){
            int u = e[0];
            int v = e[1];
            graph1[u].add(v);
        }

        for(int[] e : blueEdges){
            int u = e[0];
            int v = e[1];
            graph2[u].add(v);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        boolean[][] visited = new boolean[n][2];

        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{0,0});
        q.add(new int[]{0,1});

        visited[0][0] = true;
        visited[0][1] = true;

        int dist = 0;

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] curr = q.poll();
                int node = curr[0];
                int color = curr[1];
                 if (ans[node] == -1)
                    ans[node] = dist;

                if(color == 0){
                    // prev color is red now move to next that is blue;
                    for(int nei : graph1[node]){
                        if(!visited[nei][1]){
                            visited[nei][1] = true;
                            q.add(new int[]{nei,1});

                        }
                    }
                }
                else{
                    for(int nei : graph2[node]){
                        if(!visited[nei][0]){
                            visited[nei][0] = true;
                            q.add(new int[]{nei, 0});
                        }
                    }
                }
            }
            dist++;
        }
        return ans;
    }
}