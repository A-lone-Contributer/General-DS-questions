// In a binary tree, a lonely node is a node that is the only child of its parent node. The root of the tree is not 
// lonely because it does not have a parent node. Given the root of a binary tree, return an array containing the values 
// of all lonely nodes in the tree. Return the list in any order.

import java.util.LinkedList;
import java.util.List;


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // function to get the lonely nodes
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        setLonelyNodes(root, res, false); // root is not lonely
        return res;
    }

    // helper function to check if a certain node is lonely
    private void setLonelyNodes(TreeNode root, List<Integer> res,
                                boolean isLonely) {
        if (root == null) return;

        if (isLonely) res.add(root.val);

        setLonelyNodes(root.left, res, root.right == null);
        setLonelyNodes(root.right, res, root.left == null);
    }

}

// Time Complexity : O(n)
// Space Complexity : O(n)
