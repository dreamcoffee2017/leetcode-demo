//设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。 
//
// 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。 
//
// 示例: 
//
// 
//int k = 3;
//int[] arr = [4,5,8,2];
//KthLargest kthLargest = new KthLargest(3, arr);
//kthLargest.add(3);   // returns 4
//kthLargest.add(5);   // returns 5
//kthLargest.add(10);  // returns 5
//kthLargest.add(9);   // returns 8
//kthLargest.add(4);   // returns 8
// 
//
// 说明: 
//你可以假设 nums 的长度≥ k-1 且k ≥ 1。 
// Related Topics 堆

package leetcode;

import java.util.PriorityQueue;

public class KthLargestElementInAStreamTest {

    public static void main(String[] args) {
//        KthLargest heap = new KthLargestElementInAStreamTest().new KthLargest(1, new int[]{});
//        int[] ary = {-3, -2, -4, 0, 4};
        KthLargest heap = new KthLargestElementInAStreamTest().new KthLargest(3, new int[]{5, -1});
        int[] ary = {2, 1, -1, 3, 4};
        for (int a : ary) {
            System.out.println(heap.add(a));
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class KthLargest {
        int k;
        PriorityQueue<Integer> q;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            q = new PriorityQueue<>(k);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (q.size() < k) {
                q.offer(val);
            } else if (val > q.peek()) {
                q.poll();
                q.offer(val);
            }
            return q.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}