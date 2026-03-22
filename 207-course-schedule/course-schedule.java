import java.util.*;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Build graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]); 
        }

        int[] state = new int[numCourses]; 
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, adj, state)) return false; // cycle found
        }

        return true;
    }

    // returns true if cycle exists
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] state) {

        if (state[node] == 1) return true;  // cycle
        if (state[node] == 2) return false; // already safe

        state[node] = 1; // mark visiting

        for (int nei : adj.get(node)) {
            if (dfs(nei, adj, state)) return true;
        }

        state[node] = 2; 
        return false;
    }
}