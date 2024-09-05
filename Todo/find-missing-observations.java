class Solution {
  // Method to calculate the missing dice rolls
  public int[] missingRolls(int[] rolls, int mean, int n) {

    // Calculate the total sum we expect for all dice rolls (both existing and missing)
    final int targetSum = (rolls.length + n) * mean;

    // Calculate the sum of the missing dice rolls by subtracting the sum of the existing rolls
    int missingSum = targetSum - Arrays.stream(rolls).sum();

    // If the sum of missing rolls exceeds the possible bounds (less than n or greater than n*6), return an empty array
    if (missingSum > n * 6 || missingSum < n)
      return new int[] {};

    // Initialize an array of size 'n' to store the missing dice rolls
    int[] ans = new int[n];

    // Fill the array with the base value of missingSum divided evenly among all rolls
    Arrays.fill(ans, missingSum / n);

    // Compute the remainder of missingSum that couldn't be evenly distributed
    missingSum %= n;

    // Distribute the remainder across the first 'missingSum' elements of the array by incrementing them by 1
    for (int i = 0; i < missingSum; ++i)
      ++ans[i];

    // Return the final array of missing dice rolls
    return ans;
  }
}
