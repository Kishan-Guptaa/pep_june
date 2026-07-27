class Solution {
    public boolean isValid(String s) {
        Stack<Character>st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                char it = st.pop();
                if(it == '(' && ch == ')' || it == '{' && ch == '}' || it == '[' && ch == ']'){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}