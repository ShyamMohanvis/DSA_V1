class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        // Step 1: Not enough cables
        if (connections.length < n - 1) return -1;
        
        int[] parent = new int[n];
        
        // Initialize parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        // Union-Find
        for (int[] conn : connections) {
            union(conn[0], conn[1], parent);
        }
        
        // Count components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (find(i, parent) == i) {
                components++;
            }
        }
        
        // Need (components - 1) operations
        return components - 1;
    }
    
    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent); // path compression
        }
        return parent[x];
    }
    
    private void union(int x, int y, int[] parent) {
        int px = find(x, parent);
        int py = find(y, parent);
        
        if (px != py) {
            parent[px] = py;
        }
    }
}