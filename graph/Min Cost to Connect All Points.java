// https://leetcode.com/problems/min-cost-to-connect-all-points/description/?envType=problem-list-v2&envId=minimum-spanning-tree

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]>pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[] vis = new boolean[n];

        int cost = 0;
        int edgeUsed = 0;
        pq.add(new int[]{0,0});

        while(!pq.isEmpty() && edgeUsed < n){
            int[] curr = pq.poll();
            int wt = curr[0];
            int node = curr[1];
            if(vis[node]){
                continue;
            }
            vis[node] = true;
            cost += wt;
            edgeUsed++;
            for(int next = 0; next<n; next++){
                if(!vis[next]){
                    int dist = Math.abs(points[node][0] - points[next][0]) + Math.abs(points[node][1] - points[next][1]);
                    pq.add(new int[]{dist, next});
                }
            }
        }
        return cost;
    }
}