class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<int[]>cells = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                cells.add(new int[]{matrix[i][j], i, j});
            }
        }

        Collections.sort(cells, (a,b) -> a[0] - b[0]);

        int[][] ans = new int[n][m];
        int[] rowRank = new int[n];
        int[] colRank = new int[m];

        int index = 0;

        while(index < cells.size()){
            int end = index;
            while (end < cells.size() &&
                   cells.get(end)[0] == cells.get(index)[0]) {
                end++;
            }


            Map<Integer,Integer>map = new HashMap<>();   //Process this group of same values
            DSU dsu = new DSU(m + n);

            for(int i=index; i<end; i++){
                int row = cells.get(i)[1];
                int col = cells.get(i)[2];

                dsu.union(row,n + col);
            }


            for(int i=index; i<end; i++){
                int row = cells.get(i)[1];
                int col = cells.get(i)[2];

                int parent = dsu.find(row);
                int rank = Math.max(rowRank[row],colRank[col]);

                map.put(parent, Math.max(map.getOrDefault(parent, 0), rank));
            }

            for (int i = index; i < end; i++) {

                int value = cells.get(i)[0];
                int row = cells.get(i)[1];
                int col = cells.get(i)[2];
                int parent = dsu.find(row);

                int rank = map.get(parent) + 1;

                ans[row][col] = rank;

                rowRank[row] = Math.max(rowRank[row], rank);
                colRank[col] = Math.max(colRank[col], rank);
            }


                index = end;
        }

        return ans;

    }
    class DSU{
        int[] parent;
        DSU(int n){
            parent = new int[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }
        int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
         void union(int a, int b) {

            int pa = find(a);
            int pb = find(b);

            if (pa != pb) {
                parent[pb] = pa;
            }
        }
    }
}