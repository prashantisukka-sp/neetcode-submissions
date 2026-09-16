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
class BSTIterator {
    Queue<Integer> list = new LinkedList();

    public BSTIterator(TreeNode root) {
        Stack<TreeNode> st = new Stack();
        TreeNode temp = root;
        while (temp != null || !st.isEmpty()) {
            while (temp != null) {
                st.push(temp);
                temp = temp.left;
            } 
                temp = st.pop();
                list.add(temp.val);
                temp = temp.right;
            
        }
    }
    
    public int next() {
        return list.poll();
    }
    
    public boolean hasNext() {
        return !list.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */