class Solution {
    public long calculateScore(String s) {
        Stack<Integer>[]st = new Stack[26];
        long score = 0;
        for(int i=0; i<26; i++){
            st[i] = new Stack<>();
        }

        for(int i=0; i<s.length(); i++){
            int ch = s.charAt(i) - 'a';
            int mirror = 25 - ch;
            if(!st[mirror].isEmpty()){
                int j = st[mirror].pop();
                score += i - j;
            }
            else{
                st[ch].push(i);
            }
        }
        return score;
    }
}