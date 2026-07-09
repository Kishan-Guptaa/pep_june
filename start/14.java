// https://leetcode.com/problems/number-of-islands/

class Solution {
    private boolean isvalid(int i, int j, int n, int m){
        if(i < 0 || i>= n){
            return false;
        }

        if(j < 0 || j >= m){
            return false;
        }

        return true;
    }

    private void bfs(int i, int j, boolean[][] vis, char[][] grid){
        vis[i][j] = true;
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{i, j});
        int n = grid.length;
        int m = grid[0].length;
        while(!q.isEmpty()){
            int[] cell = q.remove();
            int row = cell[0];
            int col = cell[1];
            int[] drow = {-1, 0, 1, 0};
            int[] dcol = {0, 1, 0, -1};

            for(int k = 0; k < 4; k++){
                int newrow = row + drow[k];
                int newcol = col + dcol[k];

                if(isvalid(newrow, newcol, n, m)
                    && grid[newrow][newcol] == '1'
                    && !vis[newrow][newcol]){

                    vis[newrow][newcol] = true;
                    q.add(new int[]{newrow, newcol});
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    count++;
                    bfs(i,j, vis, grid);
                }
            }
        }

        return count;
    }
}