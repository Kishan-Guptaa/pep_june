class Solution {
    public int repeatedStringMatch(String a, String b) {
        int m = a.length();
        int n = b.length();

        int ans = (n + m - 1) / m;

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<ans; i++){
            sb.append(a);
        }

        if(sb.toString().contains(b)){
            return ans;
        }
        sb.append(a);
        if(sb.toString().contains(b)){
            return ans + 1;
        }
        return -1;
    }
}