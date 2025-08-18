import java.util.*;

class Solution {
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
            return parent[node] = findUpar(parent[node]); // path compression
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

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        // map each email → account index
        HashMap<String, Integer> mapMailNode = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!mapMailNode.containsKey(mail)) {
                    mapMailNode.put(mail, i);
                } else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        // collect mails belonging to the same parent
        ArrayList<ArrayList<String>> mergeMail = new ArrayList<>();
        for (int i = 0; i < n; i++) mergeMail.add(new ArrayList<>());

        for (Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUpar(it.getValue());
            mergeMail.get(node).add(mail);
        }

        // prepare answer
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergeMail.get(i).size() == 0) continue;

            Collections.sort(mergeMail.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // account name
            temp.addAll(mergeMail.get(i));
            ans.add(temp);
        }

        return ans;
    }
}
