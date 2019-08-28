import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class n101_Symmetric_Tree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

    //解法一：递归
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;

        return (t1.val == t2.val) && check(t1.left, t2.right) && check(t1.right, t2.left);
    }

    //另一种写法：逻辑更清晰
    public boolean isSymmetric2(TreeNode root) {
        if(root == null) return true; //根结点单独判断，为空则直接返回true
        return check(root.left, root.right); //递归检查左右结点
    }

    private boolean check2(TreeNode t, TreeNode s) {
        if(t != null && s != null) { //左右结点都不为空，则检查其值以及下一层的结点
            return t.val == s.val && check(t.left, s.right) && check(t.right, s.left);
        } else { //否则，最终结果由左右叶结点是否都为空来判断，即是判断条件，也是退出条件
            return t == null && s == null;
        }
    }

    //解法二：迭代——队列实现
    public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;

            q.add(t1.left);
            q.add(t2.right);

            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
    
    //解法二：迭代——栈实现
    public boolean isSymmetric3(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root.left);
        stack.push(root.right);

        while(!stack.isEmpty()) {
            TreeNode t = stack.pop();
            TreeNode p = stack.pop();

            if(t == null && p == null) continue;
            if(t == null || p == null) return false;
            if(t.val != p.val) return false;

            stack.push(t.left);
            stack.push(p.right);

            stack.push(t.right);
            stack.push(p.left);
        }
        return true;
    }
}
