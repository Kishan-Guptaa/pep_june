class Solution {
    int[] bobTime;
    int answer = Integer.MIN_VALUE;
    int[] amount;
    List<Integer>[] graph;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        this.amount = amount;
        graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        bobTime = new int[n];
        Arrays.fill(bobTime,Integer.MAX_VALUE);

        findBobPath(bob,-1,0);
        
        findAlicePath(0,-1,0,0);

        return answer;

    }
    private boolean findBobPath(int node, int parent, int time){
        if(node == 0){
            bobTime[node] = time;
            return true;
        }

        for(int next : graph[node]){
            if(next == parent){
                continue;
            }

            if(findBobPath(next, node, time+1)){
                bobTime[node] = time;
                return true;
            }
        }
        return false;
    }

    private void findAlicePath(int node, int parent, int time, int profit){
        if(time < bobTime[node]){
            profit += amount[node];
        }
        else if(time == bobTime[node]){
            profit += amount[node]/2;
        }
         boolean isLeaf = true;
        for(int next : graph[node]){
            if(next == parent){
                continue;
            }
            isLeaf = false;
            findAlicePath(next,node,time+1,profit);
            
        }

        if(isLeaf){
            answer = Math.max(answer, profit);
        }

    }
}