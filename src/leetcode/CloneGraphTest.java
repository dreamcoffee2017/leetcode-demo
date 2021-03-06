//给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。 
//
// 示例： 
//
// 
//
// 输入：
//{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
//
//解释：
//节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
//节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
//节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
//节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
// 
//
// 
//
// 提示： 
//
// 
// 节点数介于 1 到 100 之间。 
// 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。 
// 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。 
// 必须将给定节点的拷贝作为对克隆图的引用返回。 
// 
// Related Topics 深度优先搜索 广度优先搜索 图

package leetcode;

import node.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CloneGraphTest {

    public static void main(String[] args) {
        Solution solution = new CloneGraphTest().new Solution();
        Node n1 = new Node(1, new ArrayList<>());
        Node n2 = new Node(2, new ArrayList<>());
        Node n3 = new Node(3, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);
        System.out.println(solution.cloneGraph(n1));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
    class Solution {
        Map<Integer, Node> m = new HashMap<>();

        public Node cloneGraph(Node node) {
            return clone(node);
        }

        Node clone(Node x) {
            Node y = m.get(x.val);
            if (y != null)
                return y;
            y = new Node(x.val, new ArrayList<>());
            m.put(x.val, y);
            for (Node a : x.neighbors) {
                y.neighbors.add(clone(a));
            }
            return y;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
