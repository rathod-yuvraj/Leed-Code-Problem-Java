class Solution {
  // Method to return a list of integers in lexicographical order from 1 to n
  public List<Integer> lexicalOrder(int n) {
    // Initialize the list to store the result
    List<Integer> ans = new ArrayList<>();
    // Start with the number 1 (as we're generating from 1 to n)
    int curr = 1;

    // Loop until we have added n numbers to the list
    while (ans.size() < n) {
      // Add the current number to the result list
      ans.add(curr);

      // If multiplying the current number by 10 doesn't exceed n
      // this means we're moving deeper into the lexicographical tree (e.g., 1 -> 10 -> 100)
      if (curr * 10 <= n) {
        curr *= 10; // Move to the next lexicographical "branch"
      } else {
        // If multiplying by 10 exceeds n or we are at the end of a branch
        // we need to increment the number, but ensure we don't cross the bounds of lexicographical order

        // While the current number ends with 9 or has reached n
        // we need to go back up by dividing by 10 until we find a number that can be incremented
        while (curr % 10 == 9 || curr == n)
          curr /= 10; // Move back up the lexicographical tree

        // Increment to the next lexicographical number
        ++curr;
      }
    }

    // Return the final list of numbers in lexicographical order
    return ans;
  }
}
