class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int  u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] dist = new int[n];
        Arrays.fill(dist,-1);

        Queue<Integer>q = new LinkedList<>();
        q.add(0);
        dist[0] = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            for(int  next : graph[node]){
                if(dist[next] == -1){
                    dist[next] = dist[node] + 1;
                    q.add(next);
                }
            }
        }

        int maxTime = 0;

        for(int i=1; i<n; i++){
            int roundtrip = 2 * dist[i];
            int lastreply;
            if(patience[i] >= roundtrip){
                lastreply = roundtrip;
            }
            else{
                int lastsend = ((roundtrip - 1)/ patience[i]) * patience[i];
                lastreply = lastsend + roundtrip;
            }
            maxTime = Math.max(maxTime, lastreply);
        }

        return maxTime + 1;
    }
}