//给定一个二叉树，检查它是否是镜像对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 说明: 
//
// 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。 
// Related Topics 树 深度优先搜索 广度优先搜索

package leetcode;

import node.TreeNode;

public class SymmetricTreeTest {

    public static void main(String[] args) {
        Solution solution = new SymmetricTreeTest().new Solution();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(2);
        t.left.right = new TreeNode(3);
        t.right.right = new TreeNode(3);
        System.out.println(solution.isSymmetric(t));
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null)
                return true;
            return equal(root.left, root.right);
        }

        boolean equal(TreeNode x, TreeNode y) {
            if (x == null || y == null)
                return x == y;
            if (x.val != y.val)
                return false;
            if (!equal(x.left, y.right))
                return false;
            return equal(x.right, y.left);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}