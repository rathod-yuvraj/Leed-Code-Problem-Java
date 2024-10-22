class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructors to initialize tree nodes.
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // Finds the kth largest level sum in a binary tree.
    public long kthLargestLevelSum(TreeNode root, int k) {
        // List to record the sum of values at each level.
        List<Long> levelSums = new ArrayList<>();
      
        // Queue to perform level order traversal of the tree.
        Deque<TreeNode> queue = new ArrayDeque<>();
      
        // Start with the root node.
        queue.offer(root);

        // Perform level order traversal to calculate level sums.
        while (!queue.isEmpty()) {
            long levelSum = 0;
          
            // Iterate over all nodes at the current level.
            for (int count = queue.size(); count > 0; --count) {
                TreeNode currentNode = queue.pollFirst();

                // Accumulate the values of the nodes at this level.
                levelSum += currentNode.val;

                // Add child nodes for the next level.
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Store the level sum.
            levelSums.add(levelSum);
        }

        // If there are fewer levels than k, return -1.
        if (levelSums.size() < k) {
            return -1;
        }

        // Sort the sums in descending order to find the kth largest sum.
        Collections.sort(levelSums, Collections.reverseOrder());

        // Return the kth element in the sorted list, adjusting the index as list is 0-based.
        return levelSums.get(k - 1);
    }
}
