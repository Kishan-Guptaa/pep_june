class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for(int i=0; i<n; i++){
            boolean[] seen = new boolean[n+1];
            for(int j=0; j<n; j++){
                int num = matrix[i][j];
                if(seen[num]){
                    return false;
                }
                seen[num] = true;
            }
        }

        for(int i=0; i<n; i++){
            boolean[] seen = new boolean[n+1];
            for(int j=0; j<n; j++){
                int num = matrix[j][i];
                if(seen[num]){
                    return false;
                }
                seen[num] = true;
            }
        }
        return true;
    }
}