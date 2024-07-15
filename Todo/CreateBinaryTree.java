class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        // Create nodes and map parent-child relationships
        for (int[] desc : descriptions) {
            int parentVal = desc[0], childVal = desc[1], isLeft = desc[2];
            nodeMap.putIfAbsent(parentVal, new TreeNode(parentVal));
            nodeMap.putIfAbsent(childVal, new TreeNode(childVal));
            TreeNode parent = nodeMap.get(parentVal);
            TreeNode child = nodeMap.get(childVal);
            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            children.add(childVal);
        }

        // Find root (a node that is never a child)
        for (int[] desc : descriptions) {
            if (!children.contains(desc[0])) {
                return nodeMap.get(desc[0]);
            }
        }

        return null; // If no root is found
    }
}
