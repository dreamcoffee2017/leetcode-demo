//有一堆石头，每块石头的重量都是正整数。 
//
// 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下： 
//
// 
// 如果 x == y，那么两块石头都会被完全粉碎； 
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。 
// 
//
// 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 1000 
// 
// Related Topics 堆 贪心算法

package leetcode.editor.cn;

import java.util.PriorityQueue;

public class LastStoneWeightTest {

    public static void main(String[] args) {
        Solution solution = new LastStoneWeightTest().new Solution();
        System.out.println(solution.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, (a, b) -> b - a);
            for (int a : stones) {
                queue.add(a);
            }
            while (queue.size() > 1) {
                int y = queue.poll();
                int x = queue.poll();
                int z = y - x;
                if (z > 0) {
                    queue.add(z);
                }
            }
            return queue.size() == 1 ? queue.peek() : 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}