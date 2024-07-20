class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int N = rowSum.length; // Number of rows
        int M = colSum.length; // Number of columns

        int[] currRowSum = new int[N]; // Current sums of rows
        int[] currColSum = new int[M]; // Current sums of columns

        int[][] origMatrix = new int[N][M]; // Resulting matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // Fill the cell with the minimum of the remaining row and column sums
                origMatrix[i][j] = Math.min(
                    rowSum[i] - currRowSum[i], // Remaining sum needed for the current row
                    colSum[j] - currColSum[j]  // Remaining sum needed for the current column
                );

                // Update the current row and column sums
                currRowSum[i] += origMatrix[i][j];
                currColSum[j] += origMatrix[i][j];
            }
        }
        return origMatrix; // Return the filled matrix
    }
}
