class Solution {
    public int[] countOfPairs(int n, int x, int y) {

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            graph[i].add(i + 1);
            graph[i + 1].add(i);
        }
        graph[x].add(y);
        graph[y].add(x);


        int[] ans = new int[n];

        for (int start = 1; start <= n; start++) {

            int[] dist = new int[n + 1];
            Arrays.fill(dist, -1);

            Queue<Integer> q = new LinkedList<>();

            q.offer(start);
            dist[start] = 0;


            while (!q.isEmpty()) {

                int curr = q.poll();

                for (int next : graph[curr]) {

                    if (dist[next] == -1) {

                        dist[next] = dist[curr] + 1;
                        q.offer(next);
                    }
                }
            }

            for (int end = 1; end <= n; end++) {

                if (start != end) {

                    ans[dist[end] - 1]++;
                }
            }
        }


        return ans;
    }
}