
// https://leetcode.com/problems/flood-fill/description/
class Solution {
    private int[] delrow = {-1, 0, 1, 0};
    private int[] delcol = {0, 1, 0, -1};

    private boolean isvalid(int i, int j, int n, int m){
        if(i < 0 || i >= n){
            return false;
        }

        if(j < 0 || j >= m){
            return false;
        }

        return true;
    }

    private void dfs(int sr, int sc, int[][] image, int color, int inicolor, int[][] ans){
        ans[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i=0; i<4; i++){
            int nrow = delrow[i] + sr;
            int ncol = delcol[i] + sc;
            if(isvalid(nrow, ncol, n, m) && image[nrow][ncol] == inicolor && ans[nrow][ncol] != color){
                dfs(nrow, ncol, image, color, inicolor, ans);
            }

        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int inicolor = image[sr][sc];
        int[][] ans = new int[n][m];
        for(int i=0; i<n; i++){
           ans[i] = Arrays.copyOf(image[i], image[i].length);
        }
        dfs(sr,sc, image, color, inicolor, ans);
        return ans;
    }
}