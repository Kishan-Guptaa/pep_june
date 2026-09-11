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

    private void bfs(int i, int j,  boolean[][] vis, char[][] grid){
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{i,j});
        vis[i][j] = true;
        int m = grid[0].length;
        int n = grid.length;
        while(!q.isEmpty()){
            int[] cell = q.remove();
            int row = cell[0];
            int col = cell[1];
            for(int k=0; k<4; k++){
                int newrow = delRow[k] + row;
                int newcol = delCol[k] + col;
                if(isValid(newrow, newcol, n, m) && grid[newrow][newcol] == '1' && !vis[newrow][newcol]){
                    vis[newrow][newcol] = true;
                    q.add(new int[]{newrow, newcol});
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        boolean[][] vis = new boolean[n][m];
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    ans++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return ans;
    }
}