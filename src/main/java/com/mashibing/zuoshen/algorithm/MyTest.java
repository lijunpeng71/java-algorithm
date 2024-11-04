package com.mashibing.zuoshen.algorithm;

/**
 * @author [您的名字]
 * @date 2024-10-03 18:49
 * @description [类的简要描述]
 */
public class MyTest {

    private static volatile MyTest test;

    private MyTest() {
    }

    public static MyTest getInstance() {
        if (test == null) {
            synchronized (MyTest.class) {
                test = new MyTest();
            }
        }
        return test;
    }
}
