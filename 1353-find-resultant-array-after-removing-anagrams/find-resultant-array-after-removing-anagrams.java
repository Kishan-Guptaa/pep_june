class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String>ans = new ArrayList<>();
        ans.add(words[0]);

        for(int i=1; i<words.length; i++){
            int[] first = new int[26];
            int[] second = new int[26];
            String s = words[i-1];
            String p = words[i];
            for(int j=0; j<s.length(); j++){
                first[s.charAt(j) - 'a']++;
            }
            for(int j=0; j<p.length(); j++){
                second[p.charAt(j) - 'a']++;
            }

            if(!Arrays.equals(first, second)){
                ans.add(p);
            }

        }
        return ans;
    }
}