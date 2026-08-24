class Solution {
    public String trimTrailingVowels(String s) {
        int i;
        for(i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                break;
            }
        }
        return s.substring(0,i+1);
    }
}