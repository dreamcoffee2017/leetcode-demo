package node;

/**
 * TreeNode
 *
 * @author Administrator
 * @date 2019/12/16
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /*
          1
         / \
        2   3
       / \   \
      4   5   6

    h=0
    off=0
    n=1

    h=1
    off=0,1
    n=2,3

    h=2
    off=0,1,2,3
    n=4,5,6,7

    h=3
    off=0,1,2,3,4,5,6,7
    n=8,9...
    */
    public TreeNode(int[] a) {
        this.val = a[0];
        dfs(this, a, 0, 0);
    }

    private void dfs(TreeNode node, int[] a, int h, int off) {
        h++;
        off = 2 * off;
        int i = (int) Math.pow(2, h) + off - 1;
        if (i < a.length) {
            node.left = new TreeNode(a[i]);
            dfs(node.left, a, h, off);
        }
        if (i + 1 < a.length) {
            node.right = new TreeNode(a[i + 1]);
            dfs(node.right, a, h, off + 1);
        }
    }
}
