class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        boolean[] vis = new boolean[26];
        Stack<Character>st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']--;
            if (vis[ch - 'a']) {
                continue;
            }
            while(!st.isEmpty() && st.peek() > ch && freq[st.peek() - 'a'] > 0){
                vis[st.pop() - 'a'] = false;
            }
            st.push(ch);
            vis[ch - 'a'] = true; 
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : st){
            sb.append(ch);
        }
        return sb.toString();
    }
}