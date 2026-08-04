class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int req = n / 4;
        int[] freq = new int[128];
        for(char ch : s.toCharArray()){
            freq[ch]++;
        }

        if(freq['Q'] == req && freq['W'] == req && freq['R'] == req && freq['E'] == req){
            return 0;
        }

        int left = 0;
        int ans = Integer.MAX_VALUE;

        for(int right = 0; right < n; right++){
            freq[s.charAt(right)]--;
            while(freq['Q'] <= req && freq['W'] <= req && freq['R'] <= req && freq['E'] <= req){
                ans = Math.min(ans, right - left + 1);
                freq[s.charAt(left)]++;
                left++;
            }
        }
        return ans;
    }
}