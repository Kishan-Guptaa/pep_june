class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String, Integer>map = new HashMap<>();
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                sb.append(grid[i][j]).append(",");
            }
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int count = 0;
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                sb.append(grid[j][i]).append(",");
            }
            String key = sb.toString();
            count += map.getOrDefault(key, 0);
        }
        return count;
    }
}