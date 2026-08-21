class Solution {
    public int numDifferentIntegers(String word) {
        HashSet<String>set = new HashSet<>();
        int i = 0;
        while(i < word.length()){
            if(!Character.isDigit(word.charAt(i))){
                i++;
                continue;
            }
            int j = i;
            while(j<word.length() && Character.isDigit(word.charAt(j))){
                j++;
            }
            int start = i;
            while(start < j - 1 && word.charAt(start) == '0'){
                start++;
            }

            set.add(word.substring(start,j));
            i = j;
        }
        return set.size();
    }
}