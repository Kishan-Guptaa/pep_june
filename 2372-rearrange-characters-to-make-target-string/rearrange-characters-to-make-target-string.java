class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] tfreq = new int[26];
      
        for(int i=0; i<target.length(); i++){
            tfreq[target.charAt(i) - 'a']++;
        }
        int[] sfreq = new int[26];
        for(int i=0; i<s.length(); i++){
            sfreq[s.charAt(i) - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
       for(int i=0; i<26; i++){
        if(tfreq[i] > 0){
            ans = Math.min(ans, sfreq[i] / tfreq[i]);
        }
       }
       return ans;
    }
}