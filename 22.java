// https://takeuforward.org/plus/dsa/problems/cheapest-flight-within-k-stops?subject=dsa&approach=word-ladder-part-2


class Solution {
    public int CheapestFlight(int n, int[][] flights, int src, int dst, int K) {
        if(src == dst){
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

      int[] mindist = new int[n];
      Arrays.fill(mindist, Integer.MAX_VALUE);

      Queue<int[]>q = new LinkedList<>();
      q.add(new int[]{0, src, 0});

      while(!q.isEmpty()){
        int[] p = q.remove();
        int stop = p[0];
        int node = p[1];
        int dist  = p[2];

        if(stop > K){
            continue;
        }
        for(int[] neighbour : adj.get(node)){
            int adjNode = neighbour[0];
            int edgewt = neighbour[1];

            if(edgewt + dist < mindist[adjNode] && stop <= K){
                mindist[adjNode] = edgewt + dist;
                q.add(new int[]{stop + 1, adjNode, dist + edgewt});

            }
        }
      }

      if(mindist[dst] == Integer.MAX_VALUE){
        return -1;
      }

      return mindist[dst];
    }
}

