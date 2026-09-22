class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3){
            return false;
        }
        boolean consonant = false;
        boolean vowel = false;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(Character.isLetter(ch)){
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                    vowel = true;
                }
                else{
                    consonant = true;
                }
            }
            else if(Character.isDigit(ch)){
                continue;
            }
            else{
                return false;
            }
        }
        return vowel && consonant;
    }
}