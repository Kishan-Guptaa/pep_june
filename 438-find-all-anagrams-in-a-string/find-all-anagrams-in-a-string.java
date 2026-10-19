class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans = new ArrayList<>();
        if(p.length() > s.length()){
            return ans;
        }
        int[] freq = new int[26];
        int[] freq1 = new int[26];
        for(int i=0; i<p.length(); i++){
            freq[p.charAt(i) - 'a']++;
            freq1[s.charAt(i) - 'a']++;
        }
        

        if(Arrays.equals(freq, freq1)){
            ans.add(0);
        }
        for(int i=p.length(); i<s.length(); i++){
            freq1[s.charAt(i) - 'a']++;
            int j = i - p.length();
            freq1[s.charAt(j) - 'a']--;
            if(Arrays.equals(freq, freq1)){
                ans.add(j + 1);
            }
        }
        return ans;
    }
}