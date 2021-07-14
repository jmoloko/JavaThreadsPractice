package main.java.com.moloko.thread_practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Jack Milk
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Thread t1 = new Thread(foo::third);
        Thread t2 = new Thread(foo::second);
        Thread t3 = new Thread(foo::first);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
