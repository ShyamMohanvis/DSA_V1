class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean [] visited=new boolean[isConnected.length];
        int count = 0;

        // check every city
        for (int i = 0; i < isConnected.length; i++) {

            if (!visited[i]) {
                dfs(isConnected, i, visited);
                count++; 
            }
        }

        return count;

    }
    static void dfs(int[][] graph,int start,boolean[]visited){
        visited[start]=true;
       for (int i = 0; i < graph.length; i++) {
    if (graph[start][i] == 1 && !visited[i]) {
        dfs(graph, i, visited);
    }
    }

    }
}