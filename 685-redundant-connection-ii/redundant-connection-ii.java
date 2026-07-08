class Solution {
    int[] parent;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parentNode = new int[n+1];
        int[] first = null;
        int[] second = null;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(parentNode[v] == 0){
                parentNode[v] = u;
            }
            else{
                first = new int[]{parentNode[v], v};
                second = new int[]{u,v};
                edge[1] = 0;
            }
        }

        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            if(edge[1] == 0){
                continue;
            }

            int u = edge[0];
            int v = edge[1];
            if(!union(u,v)){
                if(first == null){
                    return edge;
                }
                return first;
            }

           
        }
         return second;

    }

    private boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb){
            return false;
        }

        parent[pb] = pa;
        return true;
    }

    private int find(int a){
        if(parent[a] != a){
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
}