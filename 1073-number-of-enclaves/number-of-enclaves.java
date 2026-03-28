import java.util.*;

class Solution {

    public int numEnclaves(int[][] grid) {

        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        // Step 1: push boundary land
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        q.offer(new int[]{i, j});
                        grid[i][j] = 0;
                    }
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // Step 2: BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int nr = cur[0] + dr[k];
                int nc = cur[1] + dc[k];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {
                    grid[nr][nc] = 0;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // Step 3: count remaining land
        int count = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) count++;
            }
        }

        return count;
    }
}