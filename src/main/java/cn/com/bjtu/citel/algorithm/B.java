package cn.com.bjtu.citel.algorithm;

public class B extends A {
    static {
        System.out.println("子类静态方法执行了");
    }

    {
        System.out.println("子类非静态方法执行了");
    }

    public B() {
        System.out.println("子类构造方法执行了");
    }

    public static void main(String[] args) {
        B b = new B();
    }
}
