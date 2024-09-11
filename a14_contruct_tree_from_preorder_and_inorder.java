import java.util.*;
public class a14_contruct_tree_from_preorder_and_inorder 
{
    public static class TreeNode 
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) 
        {
            this.val = val;
        }
    }

    public static class Solution 
    {
        public TreeNode buildTree(int[] preorder, int[] inorder) 
        {
            return Create(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        public TreeNode Create(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) 
        {
            if (ilo > ihi || plo > phi) 
            {
                return null;
            }

            int idx = Search(in, ilo, ihi, pre[plo]);
            int ne = idx - ilo;

            TreeNode node = new TreeNode(pre[plo]);
            node.left = Create(pre, plo + 1, plo + ne, in, ilo, idx - 1);
            node.right = Create(pre, plo + ne + 1, phi, in, idx + 1, ihi);

            return node;
        }

        public int Search(int[] in, int si, int ei, int item) 
        {
            for (int i = si; i <= ei; i++) 
            {
                if (in[i] == item) 
                {
                    return i;
                }
            }

            return -1;
        }
    }

    public static void inorderTraversal(TreeNode node) 
    {
        if (node == null) 
        {
            return;
        }

        inorderTraversal(node.left);
        System.out.print(node.val + " ");
        inorderTraversal(node.right);
    }

    public static void main(String[] args) 
    {
        Solution sol = new Solution();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = sol.buildTree(preorder, inorder);

        System.out.println("Inorder traversal of the constructed tree: ");
        inorderTraversal(root);
    }
}
