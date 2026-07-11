class Solution {
    int[] parent;

    public int removeStones(int[][] stones) {
        int n = stones.length;
        parent = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
        }    

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    union(i, j);
                }
            }
        }

        int compo = 0;
        for(int i=0; i<n; i++){
            if(find(i) == i){
                compo++;
            }
        }

        return n - compo;
    }
    private int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px != py){
            parent[px] = py;
        }
    }
}