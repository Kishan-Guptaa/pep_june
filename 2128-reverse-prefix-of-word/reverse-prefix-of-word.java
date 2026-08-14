class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        String prefix = word.substring(0,index + 1);
        String after = word.substring(index+1);
        StringBuilder sb = new StringBuilder(prefix);
        return sb.reverse().toString() + after;
        
    }
}