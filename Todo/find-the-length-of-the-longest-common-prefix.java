class TrieNode {
  // Each TrieNode has an array of children to represent digits 0-9.
  public TrieNode[] children = new TrieNode[10];
}

class Trie {
  // Method to insert a word (represented as a string) into the Trie.
  public void insert(final String word) {
    // Start from the root node.
    TrieNode node = root;
    
    // Traverse through each character of the word (which is a digit in this case).
    for (final char c : word.toCharArray()) {
      // Convert the character 'c' to an integer (digit between 0-9).
      final int i = c - '0';
      
      // If no node exists for this digit, create a new TrieNode.
      if (node.children[i] == null)
        node.children[i] = new TrieNode();
      
      // Move to the next node in the Trie (i.e., the child node for this digit).
      node = node.children[i];
    }
  }

  // Method to search for the longest common prefix between the input word and words in the Trie.
  public int search(final String word) {
    int prefixLength = 0; // Keep track of the length of the matching prefix.
    TrieNode node = root; // Start from the root node.

    // Traverse through each character of the word (digit).
    for (final char c : word.toCharArray()) {
      // Convert the character to an integer (digit between 0-9).
      final int i = c - '0';

      // If there is no matching child node for this digit, break the loop (end of matching prefix).
      if (node.children[i] == null)
        break;

      // Move to the next node in the Trie (i.e., the child node for this digit).
      node = node.children[i];

      // Increment the prefix length since this digit matches.
      ++prefixLength;
    }

    // Return the length of the matching prefix.
    return prefixLength;
  }

  // Root of the Trie, initialized as an empty TrieNode.
  private TrieNode root = new TrieNode();
}

class Solution {
  // Method to find the longest common prefix between numbers in two arrays (arr1 and arr2).
  public int longestCommonPrefix(int[] arr1, int[] arr2) {
    int ans = 0; // Variable to store the longest common prefix found.
    Trie trie = new Trie(); // Create a new Trie instance.

    // Insert all numbers from arr1 into the Trie, converting them to strings.
    for (final int num : arr1)
      trie.insert(Integer.toString(num));

    // For each number in arr2, convert it to a string and search for the longest matching prefix in the Trie.
    for (final int num : arr2)
      ans = Math.max(ans, trie.search(Integer.toString(num)));

    // Return the length of the longest common prefix found.
    return ans;
  }
}
