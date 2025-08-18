import java.util.*;

class DisjointSet {
    int[] parent, size;

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findUpar(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findUpar(parent[node]); // Path compression
    }

    void unionBySize(int u, int v) {
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);
        if (ulp_u == ulp_v) return;

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);

        int cntExtras = 0;
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];

            if (ds.findUpar(u) == ds.findUpar(v)) {
                cntExtras++;
            } else {
                ds.unionBySize(u, v);
            }
        }

        int countC = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent[i] == i) {
                countC++;
            }
        }

        int ans = countC - 1;
        if (cntExtras >= ans) {
            return ans;
        } else {
            return -1;
        }
    }
}
