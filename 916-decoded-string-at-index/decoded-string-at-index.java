class Solution {
    public String decodeAtIndex(String s, int k) {
        
        Stack<Character> st = new Stack<>();
        long size = 0;

        for (char c : s.toCharArray()) {
            st.push(c);

            if (Character.isLetter(c)) {
                size++;
            } else {
                size *= (c - '0');
            }
        }
        long target = k;
        while(!st.isEmpty()){
            char c = st.pop();
            if(Character.isDigit(c)){
                int digit = c - '0';
                size = size / digit;
                target = target % size;

                if(target == 0){
                    target =  (int)size;
                }
            }
            else{
                if( target == size){
                    return String.valueOf(c);
                }
                size--;
            }

        }
        return "";
    }
}