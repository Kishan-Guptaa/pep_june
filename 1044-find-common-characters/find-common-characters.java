class Solution {
    public List<String> commonChars(String[] words) {
        List<String>ans = new ArrayList<>();
        int[] freq = new int[26];
        for(char ch : words[0].toCharArray()){
            freq[ch - 'a']++;
        }

        for(int i=1; i<words.length; i++){
            int[] current = new int[26];
            for(char ch : words[i].toCharArray()){
                current[ch - 'a']++;
            }

            for(int j=0; j<26; j++){
                freq[j] = Math.min(freq[j],current[j]);
            }

        }
        for(int i=0; i<26; i++){
            while(freq[i] > 0){
                ans.add(String.valueOf((char)(i +  'a')));
                freq[i]--;
            }
        }
        return ans;
    }
}