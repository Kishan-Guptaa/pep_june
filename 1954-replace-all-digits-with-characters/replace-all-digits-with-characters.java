class Solution {
    public String replaceDigits(String s) {
        char[] ch = s.toCharArray();
        for(int i=1; i<ch.length; i+=2){
            int x = ch[i] - '0';
            ch[i] = (char) (ch[i-1] + x);
        }
        return new String(ch);
    }
}