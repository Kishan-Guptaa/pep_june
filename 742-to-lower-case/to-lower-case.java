class Solution {
    public String toLowerCase(String s) {
        // return s.toLowerCase();
        String ans = "";
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= 65 && ch < 91){
                ans += (char)(ch + 32);
            }
            else{
                ans += ch;
            }
        }
        return ans;
    }
}