class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer>map = new HashMap<>();
        int left = 0;
        for(int right = minSize - 1; right < s.length(); right++){
            String sub = s.substring(left, right + 1);
            HashSet<Character> set = new HashSet<>();
            for (char ch : sub.toCharArray()) {
                set.add(ch);
            }

            if(set.size() <= maxLetters){
                map.put(sub, map.getOrDefault(sub,0) + 1 );
            }
            left++;
        }
        int ans = 0;
        for(int freq : map.values()){
            ans = Math.max(ans, freq);
        }
        return ans;
    }
}