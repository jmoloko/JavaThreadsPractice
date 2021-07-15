package main.java.com.moloko.thread_practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jack Milk
 */
public class FooLockCondition {

    private ReentrantLock locker = new ReentrantLock();
    private Condition condition = locker.newCondition();
    private Condition condition2 = locker.newCondition();
    private volatile boolean checkFirst = false;
    private volatile boolean checkSecond = false;

    public void first() {
        locker.lock();
        try {
            System.out.print("First");
            checkFirst = true;
            condition.signal();
        }finally {
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
            condition2.signal();
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
                condition2.await();
            System.out.print("Third");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }

    }
}
