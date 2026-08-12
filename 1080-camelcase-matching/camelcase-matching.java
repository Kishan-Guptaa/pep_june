class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean>ans = new ArrayList<>();
        
        for(String querie : queries){
            int j = 0;
            boolean possible = true;
            for(int i=0; i<querie.length(); i++){
                char ch = querie.charAt(i);
                if(j < pattern.length() && ch == pattern.charAt(j)){
                    j++;
                }
                else if(Character.isUpperCase(ch)){
                    possible = false;
                    break;
                }
            }
            if(j != pattern.length()){
                possible = false;
            }
            ans.add(possible);
        }
        return ans;
    }
}