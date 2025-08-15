import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Graph: variable -> (neighbor -> weight)
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        // Step 1: Build the graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];
            
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            
            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }
        
        // Step 2: Answer each query
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0; // variable not in graph
            } else if (start.equals(end)) {
                results[i] = 1.0; // same variable
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(start, end, 1.0, visited, graph);
            }
        }
        
        return results;
    }
    
    // DFS: try all paths from current node to target
    private double dfs(String curr, String target, double product,
                       Set<String> visited, Map<String, Map<String, Double>> graph) {
        visited.add(curr);
        
        // Direct connection to target
        if (graph.get(curr).containsKey(target)) {
            return product * graph.get(curr).get(target);
        }
        
        // Explore neighbors
        for (Map.Entry<String, Double> neighbor : graph.get(curr).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(neighbor.getKey(), target, product * neighbor.getValue(), visited, graph);
                if (result != -1.0) {
                    return result;
                }
            }
        }
        
        return -1.0; // no path found
    }
}
