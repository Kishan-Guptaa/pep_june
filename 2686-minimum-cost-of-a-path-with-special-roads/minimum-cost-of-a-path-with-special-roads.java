class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        Map<String, Integer>dist = new HashMap<>();

        pq.offer(new int[]{0, start[0], start[1]});
        int ans = Math.abs(start[0] - target[0]) + Math.abs(start[1] - target[1]);

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0];
            int x = curr[1];
            int y = curr[2];

            String key = x + " " + y;

            if(dist.containsKey(key) && dist.get(key) <= cost){
                continue;
            }

            dist.put(key, cost);

            ans = Math.min(ans, cost + Math.abs(x - target[0]) + Math.abs(y - target[1]));

            for(int[] road : specialRoads){
                int x1 = road[0];
                int y1 = road[1];
                int x2 = road[2];
                int y2 = road[3];
                int roadCost = road[4];

                int newCost = cost + Math.abs(x - x1) + Math.abs(y - y1) + roadCost;

                String nextKey = x2 + " " + y2;
                if(!dist.containsKey(nextKey) || newCost < dist.get(nextKey)){
                    pq.offer(new int[]{newCost, x2, y2});
                }

            }
        }
        return ans;
    }
}