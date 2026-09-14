class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] vis = new boolean[numCourses][numCourses];
        for(int[] edge : prerequisites){
            vis[edge[0]][edge[1]] = true;
        }

        for(int i=0; i<numCourses; i++){
            for(int j=0; j<numCourses; j++){
                if(!vis[j][i]){
                    continue;
                }
                for(int k = 0; k < numCourses; k++){
                    if(vis[i][k]){
                        vis[j][k] = true;
                    }
                }
            }
        }
        List<Boolean>ans = new ArrayList<>();
        for(int[] q : queries){
            ans.add(vis[q[0]][q[1]]);
        }
        return ans;
    }
}