// https://leetcode.com/problems/network-delay-time/?envType=problem-list-v2&envId=9id9smj2
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        for(int i=1; i<=n-1; i++){
            boolean updated = false;
            for(int[] edge : times){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                    updated = true;
                }
            }

            if(!updated){
                break;
            }
        }

        int ans = 0;
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }

            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}