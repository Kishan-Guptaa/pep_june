class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;
        while(left < word1.length() && right < word2.length()){
            if(word1.substring(left).compareTo(word2.substring(right)) >= 0){
                sb.append(word1.charAt(left));
                left++;
            }
            else{
                sb.append(word2.charAt(right));
                right++;
            }
        }
        while(left < word1.length()){
            sb.append(word1.charAt(left));
            left++;
        }
        while(right < word2.length()){
            sb.append(word2.charAt(right));
            right++;
        }
        return sb.toString();
    }
}