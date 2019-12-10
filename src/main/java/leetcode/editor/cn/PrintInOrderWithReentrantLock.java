//我们提供了一个类： 
//
// 
//public class Foo {
//  public void one() { print("one"); }
//  public void two() { print("two"); }
//  public void three() { print("three"); }
//}
// 
//
// 三个不同的线程将会共用一个 Foo 实例。 
//
// 
// 线程 A 将会调用 one() 方法 
// 线程 B 将会调用 two() 方法 
// 线程 C 将会调用 three() 方法 
// 
//
// 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3]
//输出: "onetwothree"
//解释: 
//有三个线程会被异步启动。
//输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
//正确的输出是 "onetwothree"。
// 
//
// 示例 2: 
//
// 
//输入: [1,3,2]
//输出: "onetwothree"
//解释: 
//输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
//正确的输出是 "onetwothree"。 
//
// 
//
// 注意: 
//
// 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。 
//
// 你看到的输入格式主要是为了确保测试的全面性。 
//
package leetcode.editor.cn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrderWithReentrantLock {

    public static void main(String[] args) {
        Solution solution = new PrintInOrderWithReentrantLock().new Solution();
        solution.printInOrder(new int[]{3, 2, 1});
    }

    class Solution {

        public void printInOrder(int[] ary) {
            Foo foo = new Foo();
            for (int order : ary) {
                Runnable runnable = () -> System.out.println("order-" + order);
                new Thread(() -> {
                    try {
                        switch (order) {
                            case 1:
                                foo.first(runnable);
                                break;
                            case 2:
                                foo.second(runnable);
                                break;
                            case 3:
                                foo.third(runnable);
                                break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Foo {

        private ReentrantLock lock = new ReentrantLock();
        private Condition c2 = lock.newCondition();
        private Condition c3 = lock.newCondition();
        private int num = 1;

        public Foo() {

        }

        public void first(Runnable printFirst) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            lock.lock();
            printFirst.run();
            num++;
            c2.signal();
            lock.unlock();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            // printSecond.run() outputs "second". Do not change or remove this line.
            lock.lock();
            if (num != 2) {
                c2.await();
            }
            printSecond.run();
            num++;
            c3.signal();
            lock.unlock();
        }

        public void third(Runnable printThird) throws InterruptedException {
            // printThird.run() outputs "third". Do not change or remove this line.
            lock.lock();
            if (num != 3) {
                c3.await();
            }
            printThird.run();
            lock.unlock();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}