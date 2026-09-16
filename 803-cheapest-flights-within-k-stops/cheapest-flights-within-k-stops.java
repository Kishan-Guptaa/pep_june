class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(dst == src){
            return 0;
        }
        List<List<int[]>>adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int wt = flight[2];
            adj.get(u).add(new int[]{v,wt});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{0, src, 0});

        while(!q.isEmpty()){
            int[] p = q.poll();
            int stop = p[0];
            int node = p[1];
            int dis = p[2];

            if(stop > k){
                continue;
            }
            for(int[] neighbor : adj.get(node)){
                int adjNode = neighbor[0];
                int edgewt = neighbor[1];

                if(dis + edgewt < dist[adjNode] && stop <= k){
                    dist[adjNode] = dis + edgewt;
                    q.add(new int[]{stop + 1, adjNode, dis + edgewt });
                }
            }
        }
        
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}