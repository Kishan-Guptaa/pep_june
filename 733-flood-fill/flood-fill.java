class Solution {
    private int[] delrow = {-1, 0, 1, 0};
    private int[] delcol = {0, 1, 0, -1};
    private boolean isvalid(int i, int j, int m, int n){
        if(i<0 || i>=m){
            return false;
        }
        if(j<0 || j>=n){
            return false;
        }
        return true;
    }
    private void dfs(int sr, int sc,int[][] image, int inicolor, int color, int[][] ans){
        int m = image.length;
        int n = image[0].length;
        
        ans[sr][sc] = color;
        for(int i=0; i<4; i++){
            int row = delrow[i] + sr;
            int col = delcol[i] + sc;
            if(isvalid(row, col, m, n) && image[row][col] == inicolor && ans[row][col] != color){
                dfs(row, col, image, inicolor, color, ans);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inicolor = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        
       int[][] copy = Arrays.stream(image)
                     .map(int[]::clone)
                     .toArray(int[][]::new);

        dfs(sr,sc,image, inicolor, color, copy);
        return copy;

    }
}