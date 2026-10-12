class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        for(char ch : t.toCharArray()){
            hash[ch]++;
        }
        int minLength = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int count = 0;
        int sIndex = -1;
        while(r < s.length()){
            if(hash[s.charAt(r)] > 0){
                count++;
            }
            hash[s.charAt(r)]--;
            while(count == t.length()){
                if(r - l + 1 < minLength){
                    minLength = r - l + 1;
                    sIndex = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0){
                    count--;
                }
                l++;
            }
            r++;
        }
        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLength);
    }
}