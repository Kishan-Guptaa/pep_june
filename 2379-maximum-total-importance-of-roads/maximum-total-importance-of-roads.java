class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            degree[u]++;
            degree[v]++;
        }

        Integer[] cities = new Integer[n];
        for(int i=0; i<n; i++){
            cities[i] = i;
        }


        Arrays.sort(cities, (a, b) -> degree[a] - degree[b]);


        long[] importance = new long[n];
        long value = 1;
        for(int c : cities){
            importance[c] = value;
            value++;
        }

        long ans = 0;
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];

            ans+= importance[u] + importance[v];
        }

        return ans;
    }
}