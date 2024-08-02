class Solution {
    // Main function to find the minimum number of swaps to group all 1s or all 0s together
    public int minSwaps(int[] nums) {
        // Return the minimum of the swaps required to group all 0s or all 1s together
        return Math.min(minSwapsHelper(nums, 0), minSwapsHelper(nums, 1));
    }

    // Helper function to calculate the minimum swaps needed to group all `val` together
    public int minSwapsHelper(int[] data, int val) {
        int length = data.length;
        int totalValCount = 0;

        // Calculate the total number of `val` elements in the array
        for (int num : data) {
            if (num == val) {
                totalValCount++;
            }
        }

        // If no `val` elements or the array is entirely `val`, no swaps are needed
        if (totalValCount == 0 || totalValCount == length) {
            return 0;
        }

        // Calculate the number of non-val elements in the initial window of size `totalValCount`
        int nonValCountInWindow = 0;
        for (int i = 0; i < totalValCount; i++) {
            if (data[i] != val) {
                nonValCountInWindow++;
            }
        }

        // Initialize minimum swaps with the count of non-val elements in the initial window
        int minSwaps = nonValCountInWindow;

        // Use sliding window technique to calculate the minimum swaps needed
        for (int i = totalValCount; i < length; i++) {
            // Add the element entering the window if it's not `val`
            if (data[i] != val) {
                nonValCountInWindow++;
            }
            // Remove the element exiting the window if it's not `val`
            if (data[i - totalValCount] != val) {
                nonValCountInWindow--;
            }
            // Update the minimum swaps if the current window has fewer non-val elements
            minSwaps = Math.min(minSwaps, nonValCountInWindow);
        }

        // Return the minimum swaps found
        return minSwaps;
    }
}
