// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        for(int[] row : matrix){
            Arrays.fill(row, (int)1e9);
        }

        for(int[] it : edges){
            matrix[it[0]][it[1]] = it[2];
            matrix[it[1]][it[0]] = it[2];
        }
        

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        int maxCount = (int)1e9;
        int ans = -1;
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(i!=j && matrix[i][j] <= distanceThreshold){
                    count++;
                }
            }

            if(count < maxCount){
                maxCount = count;
                ans = i;
            }
            else if(count == maxCount){
                ans = i;
            }
        }

        return ans;
    }
}