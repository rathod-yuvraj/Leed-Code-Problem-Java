class Solution {
    private int maxOrValue; // Variable to store the maximum OR value of any subset.
    private int count; // Counter for subsets equal to the maximum OR value.
    private int[] nums; // Array to store the input numbers.

    // Method to count the number of maximum OR subsets.
    public int countMaxOrSubsets(int[] nums) {
        maxOrValue = 0; // Initialize the maximum OR value.
        // Calculate the maximum OR value by OR'ing all elements in the array.
        for (int num : nums) {
            maxOrValue |= num;
        }
        this.nums = nums; // Store the input array for further use in the method.
        dfs(0, 0); // Start the Depth First Search (DFS) traversal.
        return count; // Return the count of subsets with maximum OR value.
    }

    // Helper method to perform DFS traversal to find all subsets.
    private void dfs(int index, int currentOr) {
        // Base case: if we've considered all elements,
        // check if the current OR equals the maximum OR value.
        if (index == nums.length) {
            if (currentOr == maxOrValue) {
                count++; // Increment count if current subset OR equals max OR value.
            }
            return; // Return to explore other subsets.
        }
        // Exclude the current element and proceed to the next index.
        dfs(index + 1, currentOr);
        // Include the current element, OR it with the current value, and proceed.
        dfs(index + 1, currentOr | nums[index]);
    }
}
