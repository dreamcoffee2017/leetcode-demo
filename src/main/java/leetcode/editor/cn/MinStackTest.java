//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) -- 将元素 x 推入栈中。 
// pop() -- 删除栈顶的元素。 
// top() -- 获取栈顶元素。 
// getMin() -- 检索栈中的最小元素。 
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
// Related Topics 栈 设计

package leetcode.editor.cn;

import java.util.ArrayList;

public class MinStackTest {

    public static void main(String[] args) {
/*["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]*/
        MinStack obj = new MinStackTest().new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.array);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.array);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        ArrayList<Integer> array = new ArrayList<>();
        int min;
        int count;

        public MinStack() {
            count = 0;
        }

        public void push(int x) {
            array.add(count, x);
            if (count == 0)
                min = x;
            count++;
            min = min > x ? x : min;
        }

        public void pop() {
            if (count != 0) {
                int a = array.remove(count - 1);
                count--;
                if (a == min) {
                    if (count != 0) {
                        min = array.get(count - 1);
                        for (int i : array) {
                            min = min > i ? i : min;
                        }
                    }

                }
            }
        }

        public int top() {
            if (count != 0) {
                return array.get(count - 1);
            } else {
                return 0;
            }

        }

        public int getMin() {
            return min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}