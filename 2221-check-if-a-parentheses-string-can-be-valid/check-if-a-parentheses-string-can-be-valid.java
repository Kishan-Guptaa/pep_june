class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length() % 2 != 0){
            return false;
        }
        Stack<Integer>st1 = new Stack<>();
        Stack<Integer>st2 = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(locked.charAt(i) == '0'){
                st2.push(i);
            }
            else if(s.charAt(i) == '('){
                st1.push(i);
            }
            else{
                if(!st1.isEmpty()){
                    st1.pop();
                }
                else if(!st2.isEmpty()){
                    st2.pop();
                }
                else{
                    return false;
                }
            }
        }
        while (!st1.isEmpty() && !st2.isEmpty()) {

            if (st1.peek() < st2.peek()) {
                st1.pop();
                st2.pop();
            }
            else {
                return false;
            }
        }
        return st1.isEmpty();
    }
}