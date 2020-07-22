//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package leetcode;

import java.util.Arrays;

public class SurroundedRegionsTest {

    public static void main(String[] args) {
        Solution solution = new SurroundedRegionsTest().new Solution();
        char[][][] t = {
                {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}}
                , {{'O', 'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X', 'O'}, {'X', 'O', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'}, {'X', 'X', 'O', 'X', 'O'}}
        };
        for (char[][] c : t) {
            solution.solve(c);
            System.out.println(Arrays.deepToString(c));
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solve(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                        spread(board, i, j, 'Y');
                    }
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'Y') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        void spread(char[][] g, int x, int y, char c) {
            if (g[x][y] == 'O') {
                g[x][y] = c;
                if (x - 1 >= 0)
                    spread(g, x - 1, y, c);
                if (x + 1 < g.length)
                    spread(g, x + 1, y, c);
                if (y - 1 >= 0)
                    spread(g, x, y - 1, c);
                if (y + 1 < g[0].length)
                    spread(g, x, y + 1, c);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}