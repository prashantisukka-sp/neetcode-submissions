/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right != null) {
                int minValue = findMin(root.right);
                root.val = minValue;
                root.right = deleteNode(root.right, minValue);
            } else if (root.left != null) {
                return root.left;
            } else {
                return null;
            }
        }
        return root;
    }
    int findMin(TreeNode root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root != null ? root.val : -1;
    }
}