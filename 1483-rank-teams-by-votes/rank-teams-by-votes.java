class Solution {
    public String rankTeams(String[] votes) {
        int  n =votes[0].length();
        int[][] count = new int[26][n];
        for(String vote : votes){
            for(int pos = 0; pos < vote.length(); pos++){
                char team = vote.charAt(pos);
                count[team - 'A'][pos]++;
            }
        }
        List<Character>teams = new ArrayList<>();
        for(char ch :votes[0].toCharArray()){
            teams.add(ch);
        }
        Collections.sort(teams,  (a,b) -> {
            for(int pos = 0; pos < n; pos++){
                if(count[a - 'A'][pos] != count[b - 'A'][pos]){
                    return count[b - 'A'][pos] - count[a - 'A'][pos];
                }
            }
            return a - b;
        });
        StringBuilder ans = new StringBuilder();

        for (char ch : teams) {
            ans.append(ch);
        }

        return ans.toString();
    }
}