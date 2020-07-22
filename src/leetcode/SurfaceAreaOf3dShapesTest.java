//在 N * N 的网格上，我们放置一些 1 * 1 * 1 的立方体。 
//
// 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。 
//
// 请你返回最终形体的表面积。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：[[2]]
//输出：10
// 
//
// 示例 2： 
//
// 输入：[[1,2],[3,4]]
//输出：34
// 
//
// 示例 3： 
//
// 输入：[[1,0],[0,2]]
//输出：16
// 
//
// 示例 4： 
//
// 输入：[[1,1,1],[1,0,1],[1,1,1]]
//输出：32
// 
//
// 示例 5： 
//
// 输入：[[2,2,2],[2,1,2],[2,2,2]]
//输出：46
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 50 
// 0 <= grid[i][j] <= 50 
// 
// Related Topics 几何 数学

package leetcode;

public class SurfaceAreaOf3dShapesTest {

    public static void main(String[] args) {
        Solution solution = new SurfaceAreaOf3dShapesTest().new Solution();
        int[][][] t = {
                {{2}}
                , {{1, 2}, {3, 4}}
                ,{{1,0},{0,2}}
                ,{{1,1,1},{1,0,1},{1,1,1}}
                ,{{2,2,2},{2,1,2},{2,2,2}}
        };
        for (int[][] g : t) {
            System.out.println(solution.surfaceArea(g));
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int surfaceArea(int[][] grid) {
            int y = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int h = grid[i][j];
                    if (h == 0)
                        continue;
                    y += 2 + 4 * h;
                    if (i > 0) {
                        int x = grid[i - 1][j];
                        if (x > 0)
                            y -= 2 * Math.min(h, x);
                    }
                    if (j > 0) {
                        int x = grid[i][j - 1];
                        if (x > 0)
                            y -= 2 * Math.min(h, x);
                    }
                }
            }
            return y;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}