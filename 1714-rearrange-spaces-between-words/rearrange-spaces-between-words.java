class Solution {
    public String reorderSpaces(String text) {
        int space = 0;
        for(char ch : text.toCharArray()){
            if(ch == ' '){
                space++;
            }
        }
        String[] words = text.trim().split("\\s+");
        if(words.length == 1){
            return words[0]+" ".repeat(space);
        }
        int middleSpace = space / (words.length - 1);
        int extraGoEnd = space % (words.length - 1);
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<words.length; i++){
            sb.append(words[i]);
            if(i < words.length  - 1){
                sb.append(" ".repeat(middleSpace));
            }
        }
        sb.append(" ".repeat(extraGoEnd));

        return sb.toString();
        


    }
}