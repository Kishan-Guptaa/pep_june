// https://leetcode.com/problems/get-watched-videos-by-your-friends/description/?envType=problem-list-v2&envId=9id9smj2
class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        boolean[] visited = new boolean[n];
        Queue<Integer>q = new LinkedList<>();
        q.add(id);
        visited[id] = true;
        int currlevel = 0;
        while(!q.isEmpty() && currlevel < level){
            int size = q.size();
            for(int i=0; i<size; i++){
                int node = q.remove();
                for(int nei : friends[node]){
                    if(!visited[nei]){
                        visited[nei] = true;
                        q.add(nei);
                    }
                    
                }
            }
            currlevel++;
        }
        Map<String, Integer>map = new HashMap<>();
        while(!q.isEmpty()){
            int person = q.remove();
            for(String video : watchedVideos.get(person)){
                map.put(video, map.getOrDefault(video,0)+1);
            }
        }
        List<String>result = new ArrayList<>(map.keySet());
        result.sort(Comparator.comparingInt((String a) -> map.get(a)).thenComparing(a -> a));

        return result;
    }
}