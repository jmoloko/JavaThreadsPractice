package main.java.com.moloko.thread_practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jack Milk
 */
public class LockConditionFoo {
    private Lock locker = new ReentrantLock();
    private Condition condition = locker.newCondition();
    private volatile boolean checkFirst = false;
    private volatile boolean checkSecond = false;

    public void first() {
        try {
            System.out.print("First");
            checkFirst = true;
            condition.signalAll();
        } finally {
            locker.unlock();
        }
    }

    public void second() {
        locker.lock();
        try {
            while (!checkFirst)
                condition.await();
            System.out.print("Second");
            checkSecond = true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }


    }

    public void third() {
        locker.lock();
        try {
            while (!checkSecond)
                condition.await();
            System.out.print("Third");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
