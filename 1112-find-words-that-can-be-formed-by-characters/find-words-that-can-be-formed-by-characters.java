class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[26];
        for(int i=0; i<chars.length(); i++){
            freq[chars.charAt(i) - 'a']++;
        }

        int result = 0;
        for(int i=0; i<words.length; i++){
            int[] temp = freq.clone();
            boolean canForm = true;
            String s = words[i];
            for(char ch : s.toCharArray()){
                int index = ch - 'a';
                if(temp[index] == 0){
                    canForm = false;
                    break;
                }
                temp[index]--;
            }
            if(canForm){
                result += s.length();
            }
        }
        return result;
    }
}