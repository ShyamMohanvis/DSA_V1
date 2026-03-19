class Solution {

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // boundary + water check
        if (row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == '0') {
            return;
        }

        // mark visited
        grid[row][col] = '0';

        // 4 directions
        dfs(row - 1, col, grid); // up
        dfs(row, col + 1, grid); // right
        dfs(row + 1, col, grid); // down
        dfs(row, col - 1, grid); // left
    }
}