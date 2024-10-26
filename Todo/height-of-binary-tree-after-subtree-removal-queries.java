import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  
    TreeNode() {}
  
    TreeNode(int val) { this.val = val; }
  
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private Map<TreeNode, Integer> depthMap = new HashMap<>();
    private int[] response;

    // Main function to answer the queries based on the binary tree.
    public int[] treeQueries(TreeNode root, int[] queries) {
        calculateDepth(root);
        response = new int[depthMap.size() + 1];
      
        // Adding a base case to the map for null node.
        depthMap.put(null, 0);
      
        // Perform DFS to fill in the response array.
        depthFirstSearch(root, -1, 0);
      
        int queryCount = queries.length;
        int[] answer = new int[queryCount];
        for (int i = 0; i < queryCount; ++i) {
            answer[i] = response[queries[i]];
        }
        return answer;
    }

    // Performs the DFS traversal to compute rest depth and updates the response.
    private void depthFirstSearch(TreeNode node, int depth, int rest) {
        if (node == null) {
            return;
        }
        ++depth;
        response[node.val] = rest;
        depthFirstSearch(node.left, depth, Math.max(rest, depth + depthMap.get(node.right)));
        depthFirstSearch(node.right, depth, Math.max(rest, depth + depthMap.get(node.left)));
    }

    // Helper function to compute the depth of each node.
    private int calculateDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);
        int maxDepth = 1 + Math.max(leftDepth, rightDepth);
        depthMap.put(node, maxDepth);
        return maxDepth;
    }
}
