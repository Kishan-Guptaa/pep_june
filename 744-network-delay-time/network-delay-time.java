class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>>adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int wt = time[2];
            adj.get(u).add(new int[]{v, wt});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{0, k});

        while(!pq.isEmpty()){
            int[] p = pq.remove();
            int node = p[1];
            int wt = p[0];
            for(int[] neighbor : adj.get(node)){
                int adjNode = neighbor[0];
                int edgewt = neighbor[1];
                if(wt + edgewt < dist[adjNode]){
                    dist[adjNode] = wt + edgewt;
                    pq.add(new int[]{dist[adjNode],adjNode});
                }
            }
        }
         int max = 0;
        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max,dist[i]);
        }
        return max;
    }
}