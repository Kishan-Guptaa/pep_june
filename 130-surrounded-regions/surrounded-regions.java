class Solution {
    private int[] delRow = {-1, 0 , 1, 0};
    private int[] delCol = {0, 1, 0, -1};
    private boolean valid(int i, int j, int n, int m){
        if(i < 0 || i >= n){
            return false;
        }
        if(j < 0 || j >= m){
            return false;
        }
        return true;
    }
    private void dfs(int row, int col, char[][] board, boolean[][] vis){
        vis[row][col] = true;
        int n = board.length;
        int m = board[0].length;
        for(int i=0; i<4; i++){
            int nrow = delRow[i] + row;
            int ncol = delCol[i] + col;
            if(valid(nrow, ncol, n, m)  && !vis[nrow][ncol] && board[nrow][ncol] == 'O'){
                
                dfs(nrow, ncol, board, vis);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0; i<m; i++){
            if(board[0][i] == 'O' && !vis[0][i]){
                dfs(0, i, board, vis);
            }
            if(board[n-1][i] == 'O' && !vis[n-1][i]){
                dfs(n-1, i, board, vis);
            }
        }
        for(int i=0; i<n; i++){
            if(board[i][0] == 'O' && !vis[i][0]){
                dfs(i, 0, board, vis);
            }
            if(board[i][m-1] == 'O' && !vis[i][m-1]){
                dfs(i,m-1, board, vis);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'O' && !vis[i][j]){
                    vis[i][j] = true;
                    board[i][j] = 'X';
                }
            }
        }
    }
}