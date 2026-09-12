class Solution {
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0, -1};
    private boolean isValid(int i, int j, int n, int m){
        if(i < 0 || i >= n){
            return false;
        }
        if(j < 0 || j >= m){
            return false;
        }
        return true;
    }
    private void dfs(int row, int col, boolean[][] vis, int[][] grid){
        vis[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(isValid(nrow, ncol, n, m) && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, vis, grid);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0; i<m; i++){
            if(grid[0][i] == 1 && !vis[0][i]){
                dfs(0, i, vis, grid);
            }
            if(grid[n-1][i] == 1 && !vis[n-1][i]){
                dfs(n-1, i, vis, grid);
            }
        }

        for(int i=0; i<n; i++){
            if(grid[i][0] == 1 && !vis[i][0]){
                dfs(i, 0, vis, grid);
            }
            if(grid[i][m-1] == 1 && !vis[i][m-1]){
                dfs(i, m-1, vis, grid);
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    ans++;
                }
            }
        }
        return ans;
    }
}