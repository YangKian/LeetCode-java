public class n1123_Lowest_Common_Ancestor_of_Deepest_Leaves {

     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
 }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) {
            return root;
        }

        int left_dep = dep(root.left);
        int right_dep = dep(root.right);

        if(left_dep == right_dep) {
            return root;
        } else if (left_dep > right_dep) {
            return lcaDeepestLeaves(root.left);
        } else {
            return lcaDeepestLeaves(root.right);
        }

    }

    private int dep(TreeNode t) {
        if(t == null) {
            return 0;
        }

        return Math.max(dep(t.left), dep(t.right)) + 1;
    }
}
