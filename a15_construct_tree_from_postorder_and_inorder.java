import java.util.*;

public class a15_construct_tree_from_postorder_and_inorder 
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
        public TreeNode buildTree(int[] inorder, int[] postorder) 
        {
            return Create(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
        }

        public TreeNode Create(int[] post, int plo, int phi, int[] in, int ilo, int ihi) 
        {
            if (ilo > ihi || plo > phi) 
            {
                return null;
            }

            int idx = Search(in, ilo, ihi, post[phi]);
            int ne = idx - ilo;

            TreeNode node = new TreeNode(post[phi]); 
            node.left = Create(post, plo, plo + ne - 1, in, ilo, idx - 1); 
            node.right = Create(post, plo + ne, phi - 1, in, idx + 1, ihi); 

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

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = sol.buildTree(inorder, postorder);

        System.out.println("Inorder traversal of the constructed tree: ");
        inorderTraversal(root);
    }
}
