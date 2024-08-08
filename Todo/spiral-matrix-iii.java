class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        // Define the directions for right, down, left, and up movements respectively
        int direction[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Calculate the total number of cells to visit
        int n = rows * cols;
        
        // Initialize the result array to store the coordinates of the cells in the order they are visited
        int res[][] = new int[n][2];
        
        // Set the starting position as the first element of the result array
        res[0][0] = rStart;
        res[0][1] = cStart;
        
        // Initialize the count of visited cells, starting with the initial position
        int count = 1;
        
        // Step size for movement in the current direction, starts with 1
        int step = 1;
        
        // Index to track the current direction from the direction array
        int index = 0;
        
        // Loop until all cells are visited
        while(count < n) {
            // Each direction (right/down or left/up) needs to be processed twice
            for(int time = 0; time < 2; time++) {
                
                // Get the row and column direction increments for the current direction
                int dr = direction[index % 4][0];
                int dc = direction[index % 4][1];
                
                // Move in the current direction 'step' times
                for(int i = 0; i < step; i++) {
                    // Update the current row and column positions
                    rStart += dr;
                    cStart += dc;
                    
                    // Check if the new position is within the grid boundaries
                    if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        
                        // Add the valid position to the result array
                        res[count][0] = rStart;
                        res[count][1] = cStart;
                        
                        // Increment the count of visited cells
                        count++;
                    }
                }
                // Move to the next direction (right -> down -> left -> up)
                index++;
            }
            // Increase the step size after completing two directions
            step++;
        }
        
        // Return the array containing the order of visited cells
        return res;
    }
}
