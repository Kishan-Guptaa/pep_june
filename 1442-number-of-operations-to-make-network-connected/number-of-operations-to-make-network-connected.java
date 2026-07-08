class DisjointSet{
    int[] parent;
    int[] rank;
    DisjointSet(int n){
        rank = new int[n];
        parent = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
    }
    int findUpar(int node) {
        if (node == parent[node]) {
            return node;
        }

        // Compress the path while returning the ultimate parent
        return parent[node] = findUpar(parent[node]);
    }
    void unionByRank(int u, int v){
            int ulp_u = findUpar(u);
            int ulp_v = findUpar(v);
            if(ulp_u == ulp_v){
                return;
            }
            if(rank[ulp_u] < rank[ulp_v]){
                parent[ulp_u] = ulp_v;
            }
            else if(rank[ulp_v] < rank[ulp_u]){
                parent[ulp_v] = ulp_u;
            }
            else{
                parent[ulp_v] = ulp_u;
                rank[ulp_u]++;
            }
    }
}
class Solution {

    public int makeConnected(int n, int[][] connections) {
        int size = connections.length;
        if(size < n-1){
            return -1;
        }

        DisjointSet ds = new DisjointSet(n);
        for(int i=0; i< size; i++){
            ds.unionByRank(connections[i][0], connections[i][1]);
        }

        int count = 0;
        for(int i=0; i<n; i++){
            if(ds.parent[i] == i){
                count++;
            }
        }
        return count-1;

    }
}