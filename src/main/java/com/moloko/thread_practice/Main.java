package main.java.com.moloko.thread_practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Jack Milk
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        LockConditionFoo lockFoo = new LockConditionFoo();

        ExecutorService exec = Executors.newFixedThreadPool(3);
        exec.submit(lockFoo::first);
        exec.submit(lockFoo::second);
        exec.submit(lockFoo::third);

        exec.shutdown();

    }
}
