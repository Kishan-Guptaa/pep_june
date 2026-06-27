// https://leetcode.com/problems/word-ladder/description/


import java.util.AbstractMap;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<AbstractMap.SimpleEntry<String, Integer>>q = new LinkedList<>();
        q.add(new AbstractMap.SimpleEntry<>(beginWord,1));

        HashSet<String>st = new HashSet<>(wordList);
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

            char[] wordArr = word.toCharArray();
            for(int i=0; i<wordArr.length; i++){
                char original = wordArr[i];


                for(char ch = 'a'; ch <= 'z'; ch++){
                    wordArr[i] = ch;
                    String newWord = new String(wordArr);

                    if(st.contains(newWord)){
                        st.remove(newWord);
                        q.add(new AbstractMap.SimpleEntry<>(newWord, step+1));
                    }
                }
                wordArr[i] = original;
            }
        }
        return 0;
    }
}