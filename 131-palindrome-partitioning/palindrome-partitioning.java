class Solution {
    List<List<String>>ans = new ArrayList<>();
    List<String>current = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTrack(s,0);
        return ans;
    }
    private void backTrack(String s, int start){
        if(start == s.length()){
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int end = start; end < s.length(); end++){
            if(isPalindrome(s, start, end)){
                current.add(s.substring(start, end+1));
                backTrack(s, end+1);
                current.remove(current.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}