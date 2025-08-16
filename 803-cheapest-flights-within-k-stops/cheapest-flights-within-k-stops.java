import java.util.*;

class Pair {
    int first, second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Tuple {
    int stops, node, cost;
    public Tuple(int stops, int node, int cost) {
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build adjacency list: node -> {neighbor, price}
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        // Queue holds: {stops, node, cost}
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        while (!q.isEmpty()) {
            Tuple it = q.poll();
            int stops = it.stops;
            int node = it.node;
            int cost = it.cost;

            if (stops > k) continue;

            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;

                if (cost + edW < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edW;
                    q.add(new Tuple(stops + 1, adjNode, cost + edW));
                }
            }
        }

        return dist[dst] == (int) 1e9 ? -1 : dist[dst];
    }
}
