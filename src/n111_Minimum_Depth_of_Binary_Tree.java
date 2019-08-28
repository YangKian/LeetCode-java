import java.util.LinkedList;
import java.util.Queue;

public class n111_Minimum_Depth_of_Binary_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //递归：Time:O(n)， Space:O(n)
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
    //递归写法二
    public int minDepth1(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left +  right + 1 : Math.min(left, right) + 1;
    }

    //迭代法：二叉树的层序遍历：Time:O(n)， Space:O(n)
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; ++i) {
                TreeNode t = q.poll();
                if(t.left == null && t.right == null) return depth;
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }
            ++depth;
        }
        return -1;
    }
}
