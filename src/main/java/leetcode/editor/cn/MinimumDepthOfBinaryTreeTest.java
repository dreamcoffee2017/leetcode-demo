//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索

package leetcode.editor.cn;

public class MinimumDepthOfBinaryTreeTest {

    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTreeTest().new Solution();
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.right.left = new TreeNode(15);
        System.out.println(solution.minDepth(t));
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
        int min = 0;

        public int minDepth(TreeNode root) {
            if (root == null)
                return 0;
            int h = 0;
            end(root, h);
            return min;
        }

        void end(TreeNode x, int h) {
            h++;
            if (x.left == null && x.right == null) {
                if (min == 0 || min > h)
                    min = h;
            }else {
                if (min > 0 && h >= min)
                    return;
                if (x.left != null)
                    end(x.left, h);
                if (x.right != null)
                    end(x.right, h);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}