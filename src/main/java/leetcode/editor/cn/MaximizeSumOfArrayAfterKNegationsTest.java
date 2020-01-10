//给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。） 
//
// 以这种方式修改数组后，返回数组可能的最大和。 
//
// 
//
// 示例 1： 
//
// 输入：A = [4,2,3], K = 1
//输出：5
//解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
// 
//
// 示例 2： 
//
// 输入：A = [3,-1,0,2], K = 3
//输出：6
//解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
// 
//
// 示例 3： 
//
// 输入：A = [2,-3,-1,5,-4], K = 2
//输出：13
//解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 1 <= K <= 10000 
// -100 <= A[i] <= 100 
// 
// Related Topics 贪心算法

package leetcode.editor.cn;

public class MaximizeSumOfArrayAfterKNegationsTest {

    public static void main(String[] args) {
        Solution solution = new MaximizeSumOfArrayAfterKNegationsTest().new Solution();
        int[] A = {4, 2, 3};
        System.out.println(solution.largestSumAfterKNegations(A, 1));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestSumAfterKNegations(int[] A, int K) {
            int[] ary = new int[201];
            for (int a : A)
                ary[a + 100]++;
            int i = 0;
            while (K > 0) {
                while (ary[i] == 0)
                    i++;
                // 反转A[i]，假设 i 100 j，那么有100-i=j-100,即j=200-i
                ary[i]--;
                ary[200 - i]++;
                // i>100那么反转后小于100
                if (i > 100)
                    i = 200 - i;
                K--;
            }
            int y = 0;
            for (int j = i; j < ary.length; j++) {
                y += ary[j] * (j - 100);
            }
            return y;
        }
/*        public int largestSumAfterKNegations(int[] A, int K) {
            int y = 0;
            int min = -1;//>=0
            int max = 0;//<0
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for (int a : A) {
                if (a < 0) {
                    q.add(a);
                    if (a > max || max == 0)
                        max = a;
                } else {
                    if (a < min || min == -1)
                        min = a;
                    y += a;
                }
            }
            Integer a;
            while ((a = q.poll()) != null) {
                if (K > 0) {
                    y += -a;
                    K--;
                } else {
                    y += a;
                }
            }
            if (K % 2 == 1) {
                int x = 0;
                if (min == -1) {
                    x = -max;
                } else if (max == 0) {
                    x = min;
                } else {
                    x = Math.min(min, -max);
                }
                y -= x * 2;
            }
            return y;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}