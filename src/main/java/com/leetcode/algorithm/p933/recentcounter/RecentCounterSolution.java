package com.leetcode.algorithm.p933.recentcounter;

/**
 * 写一个Recenter类来计算特定时间范围内最近的请求
 * 请你实现 RecentCounter 类：
 * - RecentCounter() 初始化计数器，请求数为 0 。
 * - int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 * 示例 1：
 * 输入：
 * ["RecentCounter", "ping", "ping", "ping", "ping"]
 * [[], [1], [100], [3001], [3002]]
 * 输出：
 * [null, 1, 2, 3, 3]
 * 解释：
 * RecentCounter recentCounter = new RecentCounter();
 * recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
 * recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
 * recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
 * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
 * 提示：
 * 1 <= t <= 109
 * 保证每次对 ping 调用所使用的 t 值都 严格递增
 * 至多调用 ping 方法 104 次
 */
public class RecentCounterSolution {
    //1.创建数组存放请求，最大合法请求次数为3001次（双闭区间）
    final int length = 3002;
    //2.记录起止索引，从0开始
    int start = 0, end = 0;
    int[] array = new int[length];

    public int ping(int t) {
        //3.存放请求后，更新起止索引
        array[end++] = t;//存放最近一次请求，结束索引加1
        end = end == length ? 0 : end;//越界后，从头开始
        //从start位置正向查找复合要求的请求次数
        while (array[start] < t - 3000) {//过滤所有不符合要求的数据
            start++;//开始指针后移一位，继续循环检测下一个位置的元素
            start = start == length ? 0 : start;//越界后从头开始
        }
        //4.通过end与start差值计算请求次数
        if (start > end) {
            return length - (start - end);
        }
        //此时，end为最后一次请求+1的索引，start是3000毫秒前的第一次合法请求的索引
        return end - start;
    }
}
