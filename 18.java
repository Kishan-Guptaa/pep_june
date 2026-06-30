//https://takeuforward.org/plus/dsa/problems/print-shortest-path-?subject=dsa&approach=word-ladder-part-2

class Solution {
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
     List<List<int[]>>adj = new ArrayList<>();  //maybe size will be n
     for(int i=0; i<=n; i++){
        adj.add(new ArrayList<>());
     }

     for(int[] edge : edges){
        int u = edge[0];
        int v = edge[1];
        int wt = edge[2];

        adj.get(v).add(new int[]{u,wt});
        adj.get(u).add(new int[]{v,wt});
     }

     int[] dist = new int[n+1];
     Arrays.fill(dist, Integer.MAX_VALUE);

     PriorityQueue<int[]>pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

     dist[1] = 0;
     pq.add(new int[]{0,1});

     int[] parent = new int[n+1];
     for(int i=1; i<=n; i++){
        parent[i] = i;

     }
     while(!pq.isEmpty()){
        int[] curr = pq.remove();
        int step = curr[0];
        int node = curr[1];

        for(int[] neighbour : adj.get(node)){
            int adjNode = neighbour[0];
            int edwt = neighbour[1];
            if(step + edwt < dist[adjNode] ){
                dist[adjNode] = step + edwt;
                parent[adjNode] = node;
                pq.add(new int[]{dist[adjNode], adjNode});
            }
        }
     }

     if(dist[n] == Integer.MAX_VALUE){
        return Arrays.asList(-1);
     }

     List<Integer>path = new ArrayList<>();
     int node = n;
     while(parent[node] != node){
        path.add(node);
        node = parent[node];
     }

     path.add(1);
     Collections.reverse(path);
     path.add(0,dist[n]);
     return path;

    

    }
}



