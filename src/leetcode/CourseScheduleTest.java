//现在你总共有 n 门课需要选，记为 0 到 n-1。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1] 
//
// 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？ 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。 
//
// 示例 2: 
//
// 输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。 
//
// 说明: 
//
// 
// 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 
//
// 提示: 
//
// 
// 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。 
// 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。 
// 
// 拓扑排序也可以通过 BFS 完成。 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序

package leetcode;

import java.util.HashSet;

public class CourseScheduleTest {

    public static void main(String[] args) {
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 深度优先
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (numCourses <= 0) {
                return false;
            }
            int plen = prerequisites.length;
            if (plen == 0) {
                return true;
            }
            int[] marked = new int[numCourses];
            HashSet<Integer>[] graph = new HashSet[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new HashSet<>();
            }
            for (int[] p : prerequisites) {
                graph[p[1]].add(p[0]);
            }
            for (int i = 0; i < numCourses; i++) {
                if (dfs(i, graph, marked)) {
                    return false;
                }
            }
            return true;
        }

        // 是否成环
        boolean dfs(int i, HashSet<Integer>[] graph, int[] marked) {
            if (marked[i] == 1) {
                // 从正在访问中，到正在访问中，表示遇到了环
                return true;
            }
            if (marked[i] == 2) {
                return false;
            }
            marked[i] = 1;
            HashSet<Integer> successorNodes = graph[i];
            for (Integer successor : successorNodes) {
                if (dfs(successor, graph, marked)) {
                    return true;
                }
            }
            marked[i] = 2;
            return false;
        }

        // 广度优先
   /*     public boolean canFinish(int numCourses, int[][] prerequisites) {
            // 入度，边
            int[] in = new int[numCourses];
            boolean[] edges = new boolean[prerequisites.length];
            for (int[] e : prerequisites) {
                in[e[0]]++;
            }
            boolean find = true;
            while (find) {
                find = false;
                for (int i = 0; i < edges.length; i++) {
                    if (edges[i]) continue;  //边访问过，循环继续
                    if (in[prerequisites[i][1]] != 0) continue;
                    find = true;
                    in[prerequisites[i][0]]--;
                    edges[i] = true;
                }
            }
            for (int i : in) {
                if (i != 0) return false;
            }
            return true;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}