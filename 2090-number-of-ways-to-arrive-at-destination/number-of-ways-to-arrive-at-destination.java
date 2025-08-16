class Solution {
    class Pair {
        long first;
        int second;
        Pair(long first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int countPaths(int n, int[][] roads) {
        int mod = (int)(1e9 + 7);
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] it : roads) {
            adj.get(it[0]).add(new Pair(it[2], it[1]));
            adj.get(it[1]).add(new Pair(it[2], it[0]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.first, y.first));
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[n];

        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        while (pq.size() != 0) {
            long dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for (Pair it : adj.get(node)) {
                int adjNode = it.second;
                long edW = it.first;

                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(dis + edW, adjNode));
                    ways[adjNode] = ways[node];
                } 
                else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] = (int)((ways[adjNode] + (long)ways[node]) % mod);
                }
            }
        }

        return ways[n - 1] % mod;
    }
}
