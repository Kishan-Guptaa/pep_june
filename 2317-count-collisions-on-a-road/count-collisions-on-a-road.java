class Solution {
    public int countCollisions(String directions) {
        Stack<Character>st = new Stack<>();
        int colli = 0;
        for(char ch : directions.toCharArray()){
            if(ch == 'R'){
                st.push(ch);
            }
            else if(ch == 'S'){
                while(!st.isEmpty() && st.peek() == 'R'){
                    st.pop();
                    colli++;
                }
                st.push('S');
            }
            else{
                if(!st.isEmpty() && st.peek() == 'R'){
                    st.pop();
                    colli += 2;
                    while (!st.isEmpty() && st.peek() == 'R') {
                        st.pop();
                        colli++;
                    }
                    st.push('S');
                }
                else if(!st.isEmpty() && st.peek() == 'S'){
                    colli++;
                }
            }
        }
        return colli;
    }
}