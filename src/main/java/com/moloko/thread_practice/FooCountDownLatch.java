package main.java.com.moloko.thread_practice;

import java.util.concurrent.CountDownLatch;

/**
 * @author Jack Milk
 */
public class FooCountDownLatch {
    CountDownLatch latch1 = new CountDownLatch(1);
    CountDownLatch latch2 = new CountDownLatch(1);

    public void first() {
        System.out.print("First");
        latch1.countDown();
    }

    public void second() {
        try {
            latch1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("Second");
        latch2.countDown();

    }

    public void third() {
        try {
            latch2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("Third");
    }
}
