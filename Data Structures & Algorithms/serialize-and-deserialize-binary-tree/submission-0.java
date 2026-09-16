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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> l = new ArrayList();
        dfsSerialize(root, l);
        return String.join(",", l);
    }

    void dfsSerialize(TreeNode node, List<String> l) {
        if (node == null) {
            l.add("N");
            return;
        }
        l.add(String.valueOf(node.val));
        dfsSerialize(node.left, l);
        dfsSerialize(node.right, l);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] i = {0};
        return dfsDeserialize(i, data.split(","));
    }

    TreeNode dfsDeserialize(int[] i, String[] s) {
        if (s[i[0]].equals("N")) {
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(s[i[0]]));
        i[0]++;
        node.left = dfsDeserialize(i, s);
        node.right = dfsDeserialize(i, s);
        return node;
    }
}
