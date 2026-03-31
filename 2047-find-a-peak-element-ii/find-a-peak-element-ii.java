class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int left = 0, right = m - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // find max element row in mid column
            int maxRow = 0;
            for (int i = 0; i < n; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            int leftVal = mid > 0 ? mat[maxRow][mid - 1] : -1;
            int rightVal = mid < m - 1 ? mat[maxRow][mid + 1] : -1;

            // check peak
            if (mat[maxRow][mid] > leftVal && mat[maxRow][mid] > rightVal) {
                return new int[]{maxRow, mid};
            } 
            else if (leftVal > mat[maxRow][mid]) {
                right = mid - 1; // move left
            } 
            else {
                left = mid + 1; // move right
            }
        }

        return new int[]{-1, -1};
    }
}