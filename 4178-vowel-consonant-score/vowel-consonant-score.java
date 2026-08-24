class Solution {
    public int vowelConsonantScore(String s) {
        int n = s.length();
        int v = 0;
        int c = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                v++;
            }
            else if (ch >= 'a' && ch <= 'z') {
                c++;
            }
        }
        if (c == 0) {
            return 0;
        }

        return v/c;
    }
}