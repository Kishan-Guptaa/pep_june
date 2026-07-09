class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
       int n = quiet.length;
        List<List<Integer>>graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int[] it: richer){
            int rich = it[0];
            int poor = it[1];

            graph.get(rich).add(poor);
            indegree[poor]++;
        }

        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            ans[i] = i;
        }

        Queue<Integer>q = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            for(int next : graph.get(node)){
                if(quiet[ans[node]] < quiet[ans[next]]){
                    ans[next] = ans[node];

                }

                indegree[next]--;

                if(indegree[next ] == 0){
                    q.add(next);
                }
            }

        }

        return ans;
    }
}