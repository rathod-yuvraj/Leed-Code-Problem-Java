class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int row = 0; row <= grid.length - 3; row++) {
            for (int col = 0; col <= grid[0].length - 3; col++) {
                if (isMagicSquare(grid, row, col)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        // Check if the center is 5 (necessary condition for a 3x3 magic square with 1-9)
        if (grid[row + 1][col + 1] != 5) return false;

        // Sum of rows, columns, and diagonals should be 15
        int[] sums = new int[8];
        for (int i = 0; i < 3; i++) {
            sums[0] += grid[row + i][col];         // Column 1
            sums[1] += grid[row + i][col + 1];     // Column 2
            sums[2] += grid[row + i][col + 2];     // Column 3
            sums[3] += grid[row][col + i];         // Row 1
            sums[4] += grid[row + 1][col + i];     // Row 2
            sums[5] += grid[row + 2][col + i];     // Row 3
        }
        sums[6] = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2]; // Diagonal 1
        sums[7] = grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2]; // Diagonal 2

        // Check if all sums are 15 and numbers are distinct from 1 to 9
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j];
                if (num < 1 || num > 9 || seen[num]) return false;
                seen[num] = true;
            }
        }
        for (int sum : sums) {
            if (sum != 15) return false;
        }

        return true;
    }
}
