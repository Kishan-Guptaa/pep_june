class Solution {
    public String decodeString(String s) {
        Stack<Integer>CountSt = new Stack<>();
        Stack<String>StringSt = new Stack<>();
        int num = 0;
        String currString = "";
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            else if(ch == '['){
                CountSt.push(num);
                StringSt.push(currString);
                num = 0;
                currString = "";
            }
            else if(ch == ']'){
                int rptime = CountSt.pop();
                String preString = StringSt.pop();

                StringBuilder sb = new StringBuilder(preString);
                for(int i=0; i<rptime; i++){
                    sb.append(currString);
                }
                currString = sb.toString();
            }
            else{
                currString += ch;
            }


        }
        return currString;
    }
}