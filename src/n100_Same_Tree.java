public class n100_Same_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
