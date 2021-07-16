package main.java.com.moloko.thread_practice;

/**
 * @author Jack Milk
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        FooLockCondition fl = new FooLockCondition();
        FooCountDownLatch fcd = new FooCountDownLatch();
        Thread t1 = new Thread(fcd::third);
        Thread t2 = new Thread(fcd::second);
        Thread t3 = new Thread(fcd::first);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
