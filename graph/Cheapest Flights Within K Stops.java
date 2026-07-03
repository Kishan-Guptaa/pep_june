// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/?envType=problem-list-v2&envId=9id9smj2
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i=0; i<=k; i++){
            int[] temp = Arrays.copyOf(dist, n);
            for(int[] it : flights){
                int u = it[0];
                int v = it[1];
                int cost = it[2];

                if(dist[u] != Integer.MAX_VALUE && dist[u] + cost < temp[v]){
                    temp[v] = dist[u] + cost;
                }
            }
            dist = temp;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}