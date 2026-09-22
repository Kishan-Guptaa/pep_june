class Solution {
    public boolean isSubstringPresent(String s) {
        boolean[][] vis = new boolean[26][26];
        for(int i=0; i<s.length()-1; i++){
            int a = s.charAt(i) - 'a';
            int b = s.charAt(i+1) - 'a';
            if(a == b || vis[b][a]){
                return true;
            }
            vis[a][b] = true;
        }
        return false;
    }
}