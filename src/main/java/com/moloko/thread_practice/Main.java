package main.java.com.moloko.thread_practice;

/**
 * @author Jack Milk
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Thread t3 = new Thread(foo::third);
        Thread t2 = new Thread(foo::second);
        Thread t1 = new Thread(foo::first);

        t3.start();
        t2.start();
        t1.start();

        t3.join();
        t2.join();
        t1.join();
    }
}
