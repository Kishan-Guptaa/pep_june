import java.util.AbstractMap;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<AbstractMap.SimpleEntry<String, Integer>>q = new LinkedList<>();
        q.add(new AbstractMap.SimpleEntry<>(beginWord, 1));
        Set<String>st = new HashSet<>(wordList);
        if(!st.contains(endWord)){
            return 0;
        }
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().getKey();
            int step = q.peek().getValue();
            q.remove();
            if(word.equals(endWord)){
                return step;
            }
            char[] wordArray = word.toCharArray();
            for(int i=0; i< wordArray.length; i++){
                char original = wordArray[i];
                for(char ch='a'; ch<='z'; ch++){
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);
                    if(st.contains(newWord)){
                        st.remove(newWord);
                        q.add(new AbstractMap.SimpleEntry<>(newWord, step + 1));
                    }
                }
                wordArray[i] = original;
            }
        }
        return 0;
    }
}