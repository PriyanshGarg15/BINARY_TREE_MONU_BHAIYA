public class a16_construct_tree_from_preorder_and_postorder {
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Solution {
        public TreeNode buildTree(int[] preorder, int[] postorder) {
            return Create(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
        }

        public TreeNode Create(int[] pre, int plo, int phi, int[] post, int pso, int psi) {
            if (plo > phi || pso > psi) {
                return null;
            }

            TreeNode node = new TreeNode(pre[plo]);

            if (plo == phi) { // If there's only one element, it's a leaf node
                return node;
            }

            int idx = Search(post, pso, psi, pre[plo + 1]); // Root of left subtree in preorder is pre[plo + 1]
            int ne = idx - pso + 1; // Number of nodes in the left subtree

            node.left = Create(pre, plo + 1, plo + ne, post, pso, idx);  // Left subtree
            node.right = Create(pre, plo + ne + 1, phi, post, idx + 1, psi - 1);  // Right subtree

            return node;
        }

        public int Search(int[] post, int si, int ei, int item) {
            for (int i = si; i <= ei; i++) {
                if (post[i] == item) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.val + " ");
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        TreeNode root = sol.buildTree(preorder, postorder);

        System.out.println("Inorder traversal of the constructed tree: ");
        inorderTraversal(root);
    }
}
