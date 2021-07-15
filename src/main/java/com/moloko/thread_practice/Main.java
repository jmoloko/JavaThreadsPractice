package main.java.com.moloko.thread_practice;

/**
 * @author Jack Milk
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        FooLockCondition fl = new FooLockCondition();
        Thread t1 = new Thread(fl::third);
        Thread t2 = new Thread(fl::second);
        Thread t3 = new Thread(fl::first);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
