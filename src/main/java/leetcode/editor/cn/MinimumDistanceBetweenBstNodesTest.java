//给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。 
//
// 示例： 
//
// 
//输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树结点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \    
//    1   3  
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。 
//
// 注意： 
//
// 
// 二叉树的大小范围在 2 到 100。 
// 二叉树总是有效的，每个节点的值都是整数，且不重复。 
// 
// Related Topics 树 递归

package leetcode.editor.cn;

import leetcode.editor.cn.node.TreeNode;

public class MinimumDistanceBetweenBstNodesTest {

    public static void main(String[] args) {
        Solution solution = new MinimumDistanceBetweenBstNodesTest().new Solution();
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

        public int minDiffInBST(TreeNode root) {
            dfsTree(root);
            return min;
        }

        private void dfsTree(TreeNode node) {
            dfsDiffTree(node, node);
            TreeNode l = node.left;
            TreeNode r = node.right;
            if (l != null)
                dfsTree(l);
            if (r != null)
                dfsTree(r);
        }

        private void dfsDiffTree(TreeNode node, TreeNode cur) {
            int val = Math.abs(node.val - cur.val);
            if (val > 0)
                min = min == 0 ? val : Math.min(min, val);
            TreeNode l = cur.left;
            TreeNode r = cur.right;
            if (l != null)
                dfsDiffTree(node, l);
            if (r != null)
                dfsDiffTree(node, r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}