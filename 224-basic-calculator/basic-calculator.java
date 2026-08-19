class Solution {
    public int calculate(String s) {
        Stack<Integer>st = new Stack<>();
        Stack<Character>st2 = new Stack<>();
        int i = 0;
        boolean expectNumber = true;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(ch == ' '){
                i++;
                continue;
            }

            if(Character.isDigit(ch)){
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                st.push(num);
                expectNumber = false;   
                continue;
            }

            if(ch == '('){
                st2.push(ch);
                expectNumber = true;
            }
            else if(ch == ')'){
                while(st2.peek() != '('){
                    calculate(st,st2);
                }
                st2.pop();
                expectNumber = false;
            }
            else{
                 if (ch == '-' && expectNumber) {
                    st.push(0);
                }
                 while (!st2.isEmpty() && st2.peek() != '(') {
                    calculate(st, st2);
                }

                st2.push(ch);
                expectNumber = true;
            }
            i++;
        }
        while (!st2.isEmpty()) {
            calculate(st, st2);
        }
        return st.pop();

    }
    private void calculate(Stack<Integer>st, Stack<Character>st2){
        char op = st2.pop();
        int b = st.pop();
        int a = st.pop();
        if(op == '+'){
            st.push(a+b);
        }
        else{
            st.push(a-b);
        }
    }
}