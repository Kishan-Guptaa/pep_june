class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int count = countVowel(words[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(words[0]);
        for(int i=1; i<words.length; i++){
            if(countVowel(words[i]) == count){
                StringBuilder temp = new StringBuilder(words[i]);
                sb.append(" ").append(temp.reverse());
            }
            else{
                sb.append(" ").append(words[i]);
            }
        }
        return sb.toString();
    }
    private int countVowel(String word){
        int count = 0;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }
        }
        return count;
    }
}