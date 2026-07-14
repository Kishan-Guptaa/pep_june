class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] path : paths){
            int u = path[0] - 1;
            int v = path[1] - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] flowers = new int[n];
        for(int i=0; i<n; i++){
            boolean[] used = new boolean[5];
            for(int neighbors : graph[i]){
                used[flowers[neighbors]] = true;
            }

            for(int flower=1; flower<=4; flower++){
                if(!used[flower]){
                    flowers[i] = flower;
                    break;
                }
            }

        }
        return flowers;
    }
}