class Solution {
    // HashSet to keep track of visited substrings
    private Set<String> visited = new HashSet<>();
  
    // Variable to store the maximum number of unique splittings
    private int maxSplitCount = 1;
  
    // The input string on which splitting is performed
    private String inputString;

    // Main method that is called to get the max unique split count
    public int maxUniqueSplit(String s) {
        // Initialize inputString with the input parameter
        this.inputString = s;

        // Start recursive depth-first search from index 0 with count 0
        dfs(0, 0);

        // Return the maximum number of unique splittings found
        return maxSplitCount;
    }

    // Recursive Depth-First Search method to split the string and track maximum unique splitting
    private void dfs(int startIndex, int splitCount) {
        // Base case: if we have reached the end of the string
        if (startIndex >= inputString.length()) {
            // Update the maxSplitCount with the maximum value between current max and current split count
            maxSplitCount = Math.max(maxSplitCount, splitCount);
            return; // End the current branch of recursion
        }
        // Recursive case: try to split the string for all possible next positions
        for (int endIndex = startIndex + 1; endIndex <= inputString.length(); ++endIndex) {
            // Get the current substring to be considered
            String currentSubstring = inputString.substring(startIndex, endIndex);

            // Check and add the current substring to the visited set if it's not already present
            if (visited.add(currentSubstring)) {
                // Continue search with the next part of the string, increasing the split count
                dfs(endIndex, splitCount + 1);

                // Backtrack and remove the current substring from the visited set
                visited.remove(currentSubstring);
            }
        }
    }
}
