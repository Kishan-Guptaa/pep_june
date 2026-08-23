class Solution {
    public boolean judgeCircle(String moves) {
        int u = 0;
        int L = 0;
        for(int i=0; i<moves.length(); i++){
            if(moves.charAt(i) == 'U'){
                u++;
            }
            else if(moves.charAt(i) == 'D'){
                u--;
            }
            else if(moves.charAt(i) == 'L'){
                L++;
            }
            else if(moves.charAt(i) == 'R'){
                L--;
            }
        }
        return u == 0 && L == 0;
    }
}