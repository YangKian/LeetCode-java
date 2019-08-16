# LeetCode笔记

### 2.两数相加

>给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
>
>如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
>
>您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
>
>示例：
>
>输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
>输出：7 -> 0 -> 8
>原因：342 + 465 = 807
>

- 解法：

```java
/**
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, x = 0, y = 0, sum = 0;
        ListNode res = new ListNode(0);
        ListNode head = res;
        
        while(l1 != null || l2 != null) {
            x = l1 == null ? 0 : l1.val;
            y = l2 == null ? 0 : l2.val;
            
            sum = x + y + carry;
            carry = sum / 10;            
            head.next = new ListNode(sum % 10);
            
            head = head.next;            
            if(l1 != null) {
                l1 = l1.next;
            }            
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        
        if (carry == 1) {
            head.next = new ListNode(carry);
        }        
        return res.next;
    }
}
```

- 思路：
  - 分别取出两个链表中的数字相加：
    - 链表不等长：
      - 循环结束的条件为：两个链表都为空；
      - 短链表提前遍历完后，在后续遍历位上补0；
    - 出现进位：
      - 非最高位的进位：
        - 进位数要么为0要么为1；
        - 链表当前节点保留和对10取余后的结果；
        - 将和对10整除后的结果加到下一轮循环中；
      - 最高位进位：
        - 在循环完成后，最高位创建新节点，新节点的值为进位数的值；
  - 时间复杂度：$O(max(m, n))$ ;
  - 空间复杂度：$O(max(m, n))$；



### 3.无重复字符的最长子串

>给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
>
>示例 1:
>
>输入: "abcabcbb"
>输出: 3 
>解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
>示例 2:
>
>输入: "bbbbb"
>输出: 1
>解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
>示例 3:
>
>输入: "pwwkew"
>输出: 3
>解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
>     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
>

- 解法一：

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        final int size = s.length();
        if(size == 0) return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for(int start = 0, end = 0; end < size; ++end) {
            if(map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)), start);
            }
            ans = Math.max(end - start + 1, ans);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}
```

- 思路：

  - 滑动窗口法：

    - 哈希表：
      - 键：存储当前的字母；
      - 值：当前字符位置 + 1（+1表示从当前位置之后的下一个位置开始才不重复）；
    - 定义start和end分别指向字符串的首尾。当end指针指向的元素出现重复时，移动start指针到新的位置，位置通过哈希表查询可得；
    - 字符串的长度由end - start + 1可得

  - ```
     e.g. pwwekew
     key | p | w |
    -----|---|---|
    value| 1 | 2 |
    此时：start = 0, end = 3, len = 2,字符指向第二个w出现重复
    故：
    	start = max(map[w], start) -> start = 2;
    	len = max(end - start + 1, len) -> len = 2; 
    ```

  - 时间复杂度：$O(n)$；空间复杂度：$O(n)$；

- 解法二：

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        final int size = s.length();
        if(size == 0) return 0;
        
        int[] store = new int[128];
        int ans = 0;
        for(int start = 0, end = 0; end < size; ++end) {
            char word = s.charAt(end);
            if(store[word] != 0) {
                start = Math.max(store[word], start);
            }
            ans = Math.max(end - start + 1, ans);
            store[word] = end + 1;
        }
        return ans;
    }
}
```

- 思路：

  - 假设该字符集为ASCII 128；当字符集较小的时候，可以使用数组来代替哈希表

  - 常用的表示：

    >- `int [26]` 用于字母 ‘a’ - ‘z’ 或 ‘A’ - ‘Z’
    >- `int [128]` 用于ASCII码
    >- `int [256]` 用于扩展ASCII码



### 1123 最深叶节点的最近公共祖先

>给你一个有根节点的二叉树，找到它最深的叶节点的最近公共祖先。
>
>回想一下：
>
>叶节点 是二叉树中没有子节点的节点
>树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
>如果我们假定 A 是一组节点 S 的 最近公共祖先，<font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace">S</font> 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
>
>
>示例 1：
>
>输入：root = [1,2,3]
>输出：[1,2,3]
>示例 2：
>
>输入：root = [1,2,3,4]
>输出：[4]
>示例 3：
>
>输入：root = [1,2,3,4,5]
>输出：[2,4,5]
>
>
>提示：
>
>给你的树中将有 1 到 1000 个节点。
>树中每个节点的值都在 1 到 1000 之间。
>

- 解法：

```java
/**
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
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
```

- 思路：
  - 达到最深叶节点的条件：左节点的深度等于右节点的深度，若深度不等，则说明未达到最深叶节点，最深叶节点在深度较深的那颗子树上；
  - 某一节点的深度等于该节点左右子树深度的最大值+1，递归求解左右子树的深度，返回节点的深度，并朝深度较深的子树方向继续向下探索；



### 198. 打家劫舍

>你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
>
>给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
>
>示例 1:
>
>输入: [1,2,3,1]
>输出: 4
>解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
>     偷窃到的最高金额 = 1 + 3 = 4 。
>示例 2:
>
>输入: [2,7,9,3,1]
>输出: 12
>解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
>     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
>

- 解法一：

```java
    public int rob(int[] nums) {
        final int size = nums.length;
        if(nums == null || size == 0) return 0;
        if(size == 1) return nums[0];
        
        int[] dp = new int[size];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < size; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[size - 1];
    }
```

- 思路：
  - 动态规划；
  - 转移方程：
    - 总金额存在数组dp中。考虑第i所房子，有两种选择，抢或是不抢；
    - 若抢，则不能抢第 i - 1 所房子，即，总金额等于`dp[i - 2] + nums[i]`；
    - 若不抢，则总金额等于`dp[i - 1]`；、
    - 求出两者的最大值。
  - 时间复杂度：$O(n)$; 空间复杂度：$O(n)$；
- 解法二：

```java
    public int rob1(int[] nums) {
        int preMax=0,currMax=0;
        for(int x :nums){
            int tmp = currMax;
            currMax = Math.max(preMax+x,currMax);
            preMax =tmp;
        }
        return currMax;
    }
```

- 思路：
  - 用preMax来存储上一次的总金额，用 curMax 来存储本次的总金额；
  - 在新的一轮循环中，preMax其实是第 i - 2 次的结果， curMax 其实是上一次的结果；
  - 使用两个变量代替了dp数组，使得空间复杂度降到了$O(1)$；