class Solution {
    public int balancedString(String s) {
        int limit = s.length() / 4;
        int[] freq = new int[128];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)]++;
        }
        if(freq['Q'] == limit && freq['W'] == limit && freq['E'] == limit && freq['R'] == limit){
            return 0;
        }
        int n = s.length();
        int left = 0;
        int result = n;
        for(int right = 0; right < n; right++){
            freq[s.charAt(right)]--;
            while (freq['Q'] <= limit &&
                   freq['W'] <= limit &&
                   freq['E'] <= limit &&
                   freq['R'] <= limit) {

                    result = Math.min(result, right - left + 1);
                    freq[s.charAt(left)]++;
                    left++;

            }
        }
        return result;
    }
}