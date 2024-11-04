package cn.com.bjtu.citel.algorithm;

public class A {
    static {
        System.out.println("父类静态方法执行了");
    }

    {
        System.out.println("父类非静态方法执行了");
    }

    public A() {
        System.out.println("父类构造方法执行了");
    }
}
