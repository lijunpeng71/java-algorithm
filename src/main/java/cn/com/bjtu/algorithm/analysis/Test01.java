package cn.com.bjtu.algorithm.analysis;

import com.common.Examination;

import java.util.HashMap;
import java.util.Map;

/**
 * @author [您的名字]
 * @date 2024-09-12 12:21
 * @description [类的简要描述]
 */
public class Test01 {

    /**
     * 使用移位算法进行计算
     *
     * @param value
     * @return
     */

    public static int cal01(Integer value) {
        int count = 0, i = 0;
        for (i = 0; i < 32; i++) {
            if ((value & 0x01) == 1) {
                count++;
            }
            value >>= 1;
        }
        return count;
    }

    public static int cal02(int[] table, int value) {
        return table[value];
    }

    public static int[] initCal02() {

        return new int[]
                {
                        0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4,
                        1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
                        1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
                        2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
                        1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
                        2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
                        2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
                        3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
                        1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
                        2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
                        2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
                        3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
                        2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
                        3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
                        3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7,
                        4, 5, 5, 6, 5, 6, 6, 7, 5, 6, 6, 7, 6, 7, 7, 8
                };
    }

    public static Map<Integer, Integer> valueCountMap = new HashMap<>();

    public static int cal03(int value) {
        int count = 0;
        if (valueCountMap.containsKey(value)) {
            count = valueCountMap.get(value);
        } else {
            count = cal01(value);
            valueCountMap.put(value, count);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("方法1");
        for (int i = 1; i <= 20; i++) {
            int value = (int) (Math.random() * 255) + 1;
            Examination.start();
            cal01(value);
            Examination.end();
        }
        System.out.println("方法2");
        for (int i = 1; i <= 20; i++) {
            int value = (int) (Math.random() * 255) + 1;
            Examination.start();
            int[] table = initCal02();
            cal02(table, value);
            Examination.end();
        }
        System.out.println("方法3");
        for (int i = 1; i <= 20; i++) {
            int value = (int) (Math.random() * 255) + 1;
            Examination.start();
            cal03(value);
            Examination.end();
        }
    }
}
