class Solution {
    int[] parent = new int[26];
    public boolean equationsPossible(String[] equations) {
        for(int i=0; i<26; i++){
            parent[i] = i;
        }

        for(String eq : equations){
            if(eq.charAt(1) == '='){
                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';
                union(u,v);
            }
        }

        for(String eq : equations){
            if(eq.charAt(1) == '!'){
                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';
                if(find(u) == find(v)){
                    return false;
                }
            }
            
        }

        return true;
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