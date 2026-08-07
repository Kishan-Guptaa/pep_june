class Solution {
    public int takeCharacters(String s, int k) {
        int[] total = new int[3];
        for(char ch : s.toCharArray()){
            total[ch - 'a']++;
        }
        if(total[0] < k || total[1] < k || total[2] < k){
            return -1;
        }

        int[] allowed = new int[3];
        for(int i=0; i<3; i++){
            allowed[i] = total[i] - k;
        }

        int left = 0;
        int maxWindow = 0;
        int[] window = new int[3];
        for(int right = 0; right < s.length(); right++){
            window[s.charAt(right) - 'a']++;
            while(window[0] > allowed[0] || window[1] > allowed[1] || window[2] > allowed[2]){
                window[s.charAt(left) - 'a']--;
                left++;
            }
            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        return s.length() - maxWindow;
    }
}