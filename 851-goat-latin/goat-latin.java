class Solution {
    public String toGoatLatin(String sentence) {
        String[] sen = sentence.split(" ");
        for(int i=0; i<sen.length; i++){
             if (sen[i].charAt(0) != 'a' &&
                sen[i].charAt(0) != 'e' &&
                sen[i].charAt(0) != 'i' &&
                sen[i].charAt(0) != 'o' &&
                sen[i].charAt(0) != 'u' &&
                sen[i].charAt(0) != 'A' &&
                sen[i].charAt(0) != 'E' &&
                sen[i].charAt(0) != 'I' &&
                sen[i].charAt(0) != 'O' &&
                sen[i].charAt(0) != 'U') {
                sen[i] = sen[i].substring(1) + sen[i].charAt(0);
            }
            sen[i] += "ma";
            for(int j=0; j<=i; j++){
                sen[i] += 'a';
            }
        }
        return String.join(" ",sen);
    }
}