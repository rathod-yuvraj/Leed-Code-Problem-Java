class TreeNode {
    int val;            // Value of the node
    TreeNode left;      // Reference to the left child
    TreeNode right;     // Reference to the right child

    // Constructors
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    /**
     * Determines if two binary trees are flip equivalent.
     * Flip equivalent binary trees are trees that are 
     * the same when either flipped or not flipped at any level of their descendants.
     *
     * @param root1 the root of the first binary tree
     * @param root2 the root of the second binary tree
     * @return true if the binary trees are flip equivalent, false otherwise
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return isFlipEquiv(root1, root2);
    }

    /**
     * Helper method to perform depth-first search to determine flip equivalence.
     *
     * @param node1 the current node being compared in the first tree
     * @param node2 the current node being compared in the second tree
     * @return true if the subtrees rooted at the given nodes are flip equivalent, false otherwise
     */
    private boolean isFlipEquiv(TreeNode node1, TreeNode node2) {
        // Both nodes are null, they are flip equivalent (base case)
        if (node1 == null && node2 == null) {
            return true;
        }
      
        // If one of the nodes is null, or the values are not equal, they are not flip equivalent
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
      
        // Recursively check for flip equivalence for both children without flipping and with flipping
        // Check both possibilities: not flipped and flipped
        boolean checkWithoutFlip = isFlipEquiv(node1.left, node2.left) && isFlipEquiv(node1.right, node2.right);
        boolean checkWithFlip = isFlipEquiv(node1.left, node2.right) && isFlipEquiv(node1.right, node2.left);
      
        // Return true if either possibility resulted in flip equivalence
        return checkWithoutFlip || checkWithFlip;
    }
}
