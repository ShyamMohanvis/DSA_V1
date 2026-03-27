import java.util.*;

class Solution {

    static int[] delrow = {-1, 0, 1, 0};
    static int[] delcol = {0, 1, 0, -1};

    static void dfs(int row, int col, boolean[][] vis, char[][] board) {
        vis[row][col] = true;

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && !vis[nrow][ncol] && board[nrow][ncol] == 'O') {

                dfs(nrow, ncol, vis, board);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        //  STEP 1: Traverse boundary

        // top & bottom row
        for (int j = 0; j < m; j++) {
            if (!vis[0][j] && board[0][j] == 'O') {
                dfs(0, j, vis, board);
            }
            if (!vis[n - 1][j] && board[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, board);
            }
        }

        // left & right column
        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && board[i][0] == 'O') {
                dfs(i, 0, vis, board);
            }
            if (!vis[i][m - 1] && board[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, board);
            }
        }

        //  STEP 2: Flip surrounded regions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}