class Solution {
  
public int minimumPushes(String word) {
  int ans = 0; // Initialize the answer variable to accumulate the total pushes needed
  int[] count = new int[26]; // Create an array to store the frequency of each letter (26 letters in the English alphabet)

  // Count the frequency of each character in the input word
  for (final char c : word.toCharArray())
    ++count[c - 'a']; // Increment the count for the corresponding character

  // Sort the frequency counts in ascending order
  Arrays.sort(count);

  // Calculate the minimum pushes required
  for (int i = 0; i < 26; ++i)
    ans += count[26 - i - 1] * (i / 8 + 1); // Sum up the counts, each multiplied by a weight based on its position

  return ans; // Return the total minimum pushes calculated
}

}
