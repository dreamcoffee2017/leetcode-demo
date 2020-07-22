//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package leetcode;

public class NumberOfIslandsTest {

    public static void main(String[] args) {
        Solution solution = new NumberOfIslandsTest().new Solution();
        char[][][] t = {
                {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}
                , {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}
        };
        for (char[][] g : t) {
            System.out.println(solution.numIslands(g));
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int c = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        spread(grid, i, j);
                        c++;
                    }
                }
            }
            return c;
        }

        void spread(char[][] g, int x, int y) {
            if (g[x][y] == '1') {
                g[x][y] = '2';
                if (x - 1 >= 0)
                    spread(g, x - 1, y);
                if (x + 1 < g.length)
                    spread(g, x + 1, y);
                if (y - 1 >= 0)
                    spread(g, x, y - 1);
                if (y + 1 < g[0].length)
                    spread(g, x, y + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}