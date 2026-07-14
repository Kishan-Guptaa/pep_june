class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] indegree = new int[m][n];
        int[][] dir = {{-1,0}, {1,0}, {0, -1}, {0, 1}};

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int[] d : dir){
                    int nr = d[0] + i;
                    int nc = d[1] + j;
                    if(nr >=0 && nr <m && nc >=0 && nc < n && matrix[nr][nc] < matrix[i][j]){
                        indegree[i][j]++;
                    }
                }
            }
        }
        Queue<int[]>q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(indegree[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }

        int answer = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];

                for(int[] d : dir){
                    int nr = row + d[0];
                    int nc = col + d[1];

                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] > matrix[row][col]){
                        indegree[nr][nc]--;
                        if(indegree[nr][nc] == 0){
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }

            answer++;
        }
        return answer;
    }
}