class Solution {
    public String[] findWords(String[] words) {
        int[] row = new int[26];
        String[] keyword = {
            "qwertyuiop", "asdfghjkl", "zxcvbnm"
        };

        for(int i=0; i<keyword.length; i++){
            for(char ch : keyword[i].toCharArray()){
                row[ch - 'a'] = i;
            }
        }

        List<String>result = new ArrayList<>();
        for(String word : words){
            String lower =  word.toLowerCase();
            int firstRow = row[lower.charAt(0) - 'a'];
            boolean valid = true;
            for(char ch : lower.toCharArray()){
                if(row[ch - 'a'] != firstRow){
                    valid = false;
                    break;
                }
              
            }
              if(valid){
                    result.add(word);
                }
        }
        return result.toArray(new String[0]);
    }
}