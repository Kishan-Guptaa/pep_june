class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();

        for(char ch : order.toCharArray()){
            while(freq[ch - 'a'] > 0){
                sb.append(ch);
                freq[ch - 'a']--;
            }
        }

        for(char ch : s.toCharArray()){
            while(freq[ch - 'a'] > 0){
                sb.append(ch);
                freq[ch - 'a']--;
            }
        }
        return sb.toString();
    }
}