package edu.cscc.threads;

/** Demonstrates creating a thread by extending the Thread superclass */

public class ExtendingThread extends Thread {

    ExtendingThread() {
        super("Demo Thread");                       // calls Super Constructor of Superclass
        System.out.println("Child thread: " + this);        // displays info about the thread created
    }

    /**
     * This is the only method required to be overridden when extending the Thread superclass
     */
    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread...");
    }
}

class ExtendThread {
    public static void main(String[] args) {

        ExtendingThread t = new ExtendingThread();
        t.start();

        try {
            for (int i = 0; i <= 20; i++) {
                System.out.println("Main thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Exiting main thread...");
    }
}
