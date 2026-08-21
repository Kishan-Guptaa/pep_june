class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] position = new ArrayList[26];
        for(int i=0; i<26; i++){
            position[i] = new ArrayList<>();
        }
        for(int i=0; i<s.length(); i++){
            position[s.charAt(i) - 'a'].add(i);
        }

        int count = 0;
        for(String word : words){
            int prev = -1;
            boolean valid = true;
            for(char ch : word.toCharArray()){
                List<Integer>list = position[ch - 'a'];
                int index = upperBound(list, prev);
                if(index == list.size()){
                    valid = false;
                    break;
                }
                prev = list.get(index);
            }
            if(valid){
                count++;
            }
        }
        return count;
    }
    private int upperBound(List<Integer>list, int target){
        int left = 0;
        int right = list.size();
        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) <= target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
            
        }
        return left;
    }
}