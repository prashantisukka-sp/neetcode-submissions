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
    List<Integer> list;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        list = new ArrayList<>();
        for (int i : preorder) list.add(i);
        return buildSubTree(preorder, inorder, preorder[0]);
    }
    int getRootValue(int[] preorder, int[] elements) {
        int min = Integer.MAX_VALUE;
        int value = elements[0];
        for (int i: elements) {
            int index = list.indexOf(i);
            if (min > index) {
                value = i;
                min = index;
            }
        }
        return value;
    }
    TreeNode buildSubTree(int[] preorder, int[] inorder, int val) {
        TreeNode root = new TreeNode(val);
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex >= 1) {
            int[] leftTree = Arrays.copyOfRange(inorder, 0, rootIndex);
            int rootValue = leftTree.length > 1 ? getRootValue(preorder, leftTree) : leftTree[0];
            root.left = buildSubTree(preorder, leftTree, rootValue);
        }
        if (rootIndex < inorder.length - 1) {
            int[] rightTree = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
            int rootValue = rightTree.length > 1 ? getRootValue(preorder, rightTree) : rightTree[0];
            root.right = buildSubTree(preorder, rightTree, rootValue); 
        }
        return root;
    }
}
