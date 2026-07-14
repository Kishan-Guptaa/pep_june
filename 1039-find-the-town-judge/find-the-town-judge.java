class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n+1];
        int[] outdegree= new int[n+1];

        for(int[] it : trust){
            int person = it[0];
            int judge = it[1];

            outdegree[person]++;
            indegree[judge]++;
        }

        for(int i=1; i<=n; i++){
            if(indegree[i] == n-1 && outdegree[i] == 0){
                return i;
            }
        }
        return -1;
    }
}