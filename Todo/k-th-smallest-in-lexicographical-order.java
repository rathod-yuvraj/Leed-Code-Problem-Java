class Solution {
  // Main function to find the k-th smallest number in lexicographical order
  public int findKthNumber(int n, int k) {
    // Start with the first number (1) in lexicographical order
    long ans = 1;

    // Iterate until we find the k-th number
    for (int i = 1; i < k;) { // i tracks the position in lexicographical order
      // Get the gap between 'ans' and the next number in lexicographical order
      final long gap = getGap(ans, ans + 1, n);

      // If the current number plus the gap is less than or equal to k,
      // we know that the k-th number is beyond this gap, so we move to the next number.
      if (i + gap <= k) {
        i += gap;   // Skip all the numbers in this gap
        ++ans;      // Move to the next sibling in the lexicographical tree
      } else {
        // If the k-th number is within this gap, move down to the next level
        ++i;        // Move to the next number
        ans *= 10;  // Move deeper in the tree (e.g., from 1 -> 10)
      }
    }

    // Return the k-th smallest number
    return (int) ans;
  }

  // Helper function to calculate the gap between two numbers in the lexicographical order
  private long getGap(long a, long b, long n) {
    long gap = 0;
    // As long as 'a' is within the range [1, n], we keep calculating the gap
    while (a <= n) {
      // The gap is the difference between 'a' and 'b', but we take care not to exceed 'n'
      gap += Math.min(n + 1, b) - a;
      // Move one level deeper (e.g., from 1 -> 10 -> 100, etc.)
      a *= 10;
      b *= 10;
    }
    return gap; // Return the total gap between 'a' and 'b'
  }
}
