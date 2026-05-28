import java.util.HashSet;

class Solution {

    public boolean checkValid(int[][] matrix) {

        int n = matrix.length;

        // Rows
        for(int i = 0; i < n; i++) {

            HashSet<Integer> set = new HashSet<>();

            for(int j = 0; j < n; j++) {

                set.add(matrix[i][j]);
            }

            if(set.size() != n) {
                return false;
            }
        }

        // Columns
        for(int j = 0; j < n; j++) {

            HashSet<Integer> set = new HashSet<>();

            for(int i = 0; i < n; i++) {

                set.add(matrix[i][j]);
            }

            if(set.size() != n) {
                return false;
            }
        }

        return true;
    }
}