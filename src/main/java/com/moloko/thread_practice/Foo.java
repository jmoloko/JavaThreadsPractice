package main.java.com.moloko.thread_practice;

/**
 * @author Jack Milk
 */
public class Foo {
    boolean checkFirst = false;
    boolean checkSecond = false;

    public void first() {
        synchronized (this) {
            System.out.print("First");
            checkFirst = true;
            notifyAll();
        }
    }

    public void second() {
        synchronized (this) {
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

    }

    public void third() {
        synchronized (this) {
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
}
