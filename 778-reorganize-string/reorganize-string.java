class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        PriorityQueue<Character>pq= new PriorityQueue<>((a,b) -> freq[b - 'a'] - freq[a - 'a']);

        for(char c = 'a'; c <='z'; c++){
            if(freq[c-'a'] > 0){
                pq.offer(c);
            }
        }
        StringBuilder result = new StringBuilder ();

        while(pq.size() >= 2){
            char first = pq.poll();
            char second = pq.poll();

            result.append(first);
            result.append(second);
            freq[first - 'a']--;
            freq[second - 'a']--;


            if(freq[first - 'a'] > 0){
                pq.offer(first);
            }
            if(freq[second - 'a'] > 0){
                pq.offer(second);
            }
        }
        if(!pq.isEmpty()){
            char last = pq.poll();
            if(freq[last - 'a'] > 1){
                return "";
            }
            result.append(last);
        }
        return result.toString();
    }
}