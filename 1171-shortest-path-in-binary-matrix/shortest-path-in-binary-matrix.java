import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1;

        int[][] dir = {
            {-1,-1},{-1,0},{-1,1},
            {0,-1},        {0,1},
            {1,-1},{1,0},{1,1}
        };

        int[][] dist = new int[n][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b) -> a[0]-b[0]);

        pq.add(new int[]{1,0,0});
        dist[0][0] = 1;

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();
            int d = cur[0], r = cur[1], c = cur[2];

            if (r == n-1 && c == n-1)
                return d;

            for (int[] dxy : dir) {
                int nr = r + dxy[0];
                int nc = c + dxy[1];

                if (nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==0) {

                    if (d + 1 < dist[nr][nc]) {
                        dist[nr][nc] = d + 1;
                        pq.add(new int[]{d+1, nr, nc});
                    }
                }
            }
        }

        return -1;
    }
}