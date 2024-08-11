class Solution {
    private static final int[] DIRS = new int[] {-1, 0, 1, 0, -1};
    private int[][] grid;
    private int m;
    private int n;

    public int minDays(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        
        // If the grid is not initially a single connected component
        if (count() != 1) {
            return 0;
        }
        
        // Try removing each land cell to see if the grid splits into multiple components
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (count() != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        
        // If no single cell removal causes disconnection, it takes at least 2 days
        return 2;
    }

    private int count() {
        int target = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    ++target;
                }
            }
        }
        
        // Reset the grid back to its original state
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 2) {
                    grid[i][j] = 1;
                }
            }
        }
        return target;
    }

    private void dfs(int i, int j) {
        grid[i][j] = 2;
        for (int k = 0; k < 4; ++k) {
            int x = i + DIRS[k], y = j + DIRS[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                dfs(x, y);
            }
        }
    }
}
