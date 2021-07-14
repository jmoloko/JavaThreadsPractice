package main.java.com.moloko.thread_practice;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jack Milk
 */
public class Foo {
    private volatile boolean checkFirst = false;
    private volatile boolean checkSecond = false;

    public synchronized void first() {
        System.out.print("First");
        checkFirst = true;
        notifyAll();
    }

    public synchronized void second() {
        while (!checkFirst) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("Second");
        checkSecond = true;
        notify();
    }

    public synchronized void third() {
        while (!checkSecond) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("Third");
    }
}
