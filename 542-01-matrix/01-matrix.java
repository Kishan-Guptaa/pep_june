class Solution {
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0, -1};
    private boolean valid(int i, int j, int n, int m){
        if( i < 0 || i >= n){
            return false;
        }
        if( j < 0 || j >= m){
            return false;
        }
        return true;
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<int[]>q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j,0});
                    vis[i][j] = 1;
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            int[] cell = q.remove();
            int row = cell[0];
            int col = cell[1];
            int steps = cell[2];
            dist[row][col] = steps;
            for(int i=0; i<4; i++){
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                if(valid(newRow, newCol, n, m) && vis[newRow][newCol] == 0){
                    vis[newRow][newCol] = 1;
                    q.add(new int[]{newRow, newCol, steps+1});
                }
            }
        }

        return dist;
    }
}