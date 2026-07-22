class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] score = new long[n];
        for(int i=0; i<n; i++){
            score[edges[i]] += i;
        }

        long maxScore = Integer.MIN_VALUE;
        int answer = 0;

        for(int i=0; i<n; i++){
            if(score[i] > maxScore){
                maxScore = score[i];
                answer = i;
            }
        }
        return answer;
    }
}