class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>>adj = new ArrayList<>();
        int mod = 1000000007;
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int wt = road[2];
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        
        long[] dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[n+1];
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<long[]>pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] p = pq.remove();
            int node = (int)p[1];
            long wt = p[0];
            if(wt > dist[node]){
                continue;
            }
            for(int[] neighbor : adj.get(node)){
                int adjNode = neighbor[0];
                int edgewt = neighbor[1];
                if(wt + edgewt < dist[adjNode]){
                    dist[adjNode] = wt + edgewt;
                    ways[adjNode] = ways[node];
                    pq.add(new long[]{dist[adjNode], adjNode});
                }
                else if(edgewt + wt == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }


        return ways[n-1] % mod;
    }
}