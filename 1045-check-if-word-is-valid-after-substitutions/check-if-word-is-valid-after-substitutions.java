class Solution {
    public boolean isValid(String s) {
        Stack<Character>st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == 'a' || ch == 'b'){
                st.push(ch);
            }
            else{
                if(st.size() < 2){
                    return false;
                }
                int b = st.pop();
                int a = st.pop();
                if(b != 'b' || a != 'a'){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}