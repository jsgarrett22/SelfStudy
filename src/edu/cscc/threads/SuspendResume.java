package edu.cscc.threads;

/** Suspending and Resuming threads the modern way */
public class SuspendResume {
    public static void main(String[] args) {
        NewThread obj1 = new NewThread("One");
        NewThread obj2 = new NewThread("Two");

        obj1.t.start();     // start thread
        obj2.t.start();     // start thread

        try {
            Thread.sleep(1000);
            obj1.mySuspend();
            System.out.println("Suspending thread One");
            Thread.sleep(1000);
            obj1.myResume();
            System.out.println("Resuming thread One");
            obj2.mySuspend();
            System.out.println("Suspending thread Two");
            Thread.sleep(1000);
            obj2.myResume();
            System.out.println("Resuming thread Two");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // wait for the threads to finish
        try {
            System.out.println("Waiting for threads to finish");
            obj1.t.join();
            obj2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }
}

/** Suspending and resuming a thread the modern way */
class NewThread implements Runnable {

    String name;
    Thread t;
    boolean suspendFlag;

    NewThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        suspendFlag = false;
    }

    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " exiting.");
    }

    synchronized void mySuspend() {
        suspendFlag = true;
    }

    synchronized void myResume() {
        suspendFlag = false;
        notify();
    }
}
