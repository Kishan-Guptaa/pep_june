class Solution {
    public String decodeString(String s) {
        Stack<Integer>countStack = new Stack<>();
        Stack<String>stringStack = new Stack<>();

        int currentCount = 0;
        String currentString = "";

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                currentCount = currentCount * 10 + (ch - '0');
            }
            else if(ch == '['){
                countStack.push(currentCount);
                stringStack.push(currentString);

                currentCount = 0;
                currentString = "";
            }
            else if(ch == ']'){
                int repeatedTime =countStack.pop();
                String prevString = stringStack.pop();

                StringBuilder sb = new StringBuilder(prevString);
                for(int i=0; i<repeatedTime; i++){
                    sb.append(currentString);
                } 
                currentString = sb.toString();
            }
            else{
                currentString += ch;
            }
        }
        return currentString;
    }
}