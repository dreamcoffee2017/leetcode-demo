//现在有两种线程，氢 oxygen 和氧 hydrogen，你的目标是组织这两种线程来产生水分子。 
//
// 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。 
//
// 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。 
//
// 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。 
//
// 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。 
//
// 换句话说: 
//
// 
// 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。 
// 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。 
// 
//
// 书写满足这些限制条件的氢、氧线程同步代码。 
//
// 
//
// 示例 1: 
//
// 
//输入: "HOH"
//输出: "HHO"
//解释: "HOH" 和 "OHH" 依然都是有效解。
// 
//
// 示例 2: 
//
// 
//输入: "OOHHHH"
//输出: "HHOHHO"
//解释: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" 和 "OHHOHH" 依然都是有效解。
// 
//
// 
//
// 限制条件: 
//
// 
// 输入字符串的总长将会是 3n, 1 ≤ n ≤ 50； 
// 输入字符串中的 “H” 总数将会是 2n； 
// 输入字符串中的 “O” 总数将会是 n。 
// 
//

package leetcode;

public class BuildingH2o {

    public static void main(String[] args) {
        H2O service = new BuildingH2o().new H2O();
        int n = 2;
        for (int i = 0; i < 2 * n; i++) {
            new Thread(() -> {
                try {
                    service.hydrogen(() -> System.out.println("H"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        for (int i = 0; i < n; i++) {
            new Thread(() -> {
                try {
                    service.oxygen(() -> System.out.println("O"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class H2O {

        private int i;

        public H2O() {
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            synchronized (this) {
                while (i % 3 == 2) {
                    this.wait();
                }
                // releaseHydrogen.run() outputs "H". Do not change or remove this line.
                releaseHydrogen.run();
                i++;
                this.notifyAll();
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            synchronized (this) {
                while (i % 3 < 2) {
                    this.wait();
                }
                // releaseOxygen.run() outputs "O". Do not change or remove this line.
                releaseOxygen.run();
                i++;
                this.notifyAll();
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}