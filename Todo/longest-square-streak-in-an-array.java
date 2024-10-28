class Solution {

    // Method to find the longest streak of squaring operations until 
    // a number no longer exists within the set
    public int longestSquareStreak(int[] nums) {
        // Initialize a HashSet to store the unique numbers from the array
        Set<Integer> uniqueNumbers = new HashSet<>();
      
        // Populate the set with values from the nums array
        for (int value : nums) {
            uniqueNumbers.add(value);
        }
      
        // Initialize the answer as -1, assuming no such streak is found by default
        int longestStreak = -1;
      
        // Iterate over the array to calculate the square streaks for each number
        for (int value : nums) {
            // Initialize a temporary streak counter
            int currentStreak = 0;
          
            // Continue squaring the current number and checking its existence in the set
            while (uniqueNumbers.contains(value)) {
                value = value * value; // Square the number
                currentStreak++; // Increment the streak count
            }
          
            // Only consider streaks that consist of at least 2 numbers
            if (currentStreak > 1) {
                // Update the longest streak if the current streak is longer
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
      
        // Return the result containing the longest squaring streak
        return longestStreak;
    }
}
