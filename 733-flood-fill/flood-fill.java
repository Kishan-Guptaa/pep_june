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
    private void dfs(int sr, int sc, int[][] ans, int iniColor, int color, int[][] image){
        ans[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i=0; i<4; i++){
            int newrow = delRow[i] + sr;
            int newcol = delCol[i] + sc;
            if(isValid(newrow, newcol, n, m) && image[newrow][newcol] == iniColor && ans[newrow][newcol] != color){
                dfs(newrow, newcol, ans, iniColor, color, image);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        int[][] ans = new int[image.length][image[0].length];
        for(int i=0; i<image.length; i++){
            ans[i] = Arrays.copyOf(image[i], image[0].length);
        }
        dfs(sr,sc, ans,iniColor,  color, image);
        return ans;
    }
}