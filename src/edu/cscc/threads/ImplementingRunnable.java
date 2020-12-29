package edu.cscc;

/**  Demonstrates how to create multiple threads by implementing the Runnable interface */

public class ImplementingRunnable implements Runnable {
    String name;
    Thread t;

    ImplementingRunnable(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New Thread: " + t);
    }

    /**
     *  Run must be implemented
     */
    @Override
    public void run() {
        for (int i = 20; i > 0; i-=2) {
            try {
                System.out.println(name + " Thread: " + i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(name + " interrupted.");
            }
        }
        System.out.println("Exiting " + name + " thread");
    }
}

class ThreadDemo {
    public static void main(String[] args) {

        // Create each thread
        ImplementingRunnable t1 = new ImplementingRunnable("First");
        ImplementingRunnable t2 = new ImplementingRunnable("Second");
        ImplementingRunnable t3 = new ImplementingRunnable("Third");

        // Start each thread
        t1.t.start();
        t2.t.start();
        t3.t.start();

        // Check if each thread is alive
        System.out.println("Thread '" + t1.t.getName() + "' is alive: " + t1.t.isAlive());
        System.out.println("Thread '" + t2.t.getName() + "' is alive: " + t2.t.isAlive());
        System.out.println("Thread '" + t3.t.getName() + "' is alive: " + t3.t.isAlive());

        try {
            System.out.println("Waiting for threads to finish");
            t1.t.join();                                            // join() is a good way to wait for a thread to finish
            t2.t.join();
            t3.t.join();
            // Main thread entry
            try {
                for (int i = 0; i <= 20; i++) {
                    System.out.println("Main thread: " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // Check if each thread is alive
        System.out.println("Thread '" + t1.t.getName() + "' is alive: " + t1.t.isAlive());
        System.out.println("Thread '" + t2.t.getName() + "' is alive: " + t2.t.isAlive());
        System.out.println("Thread '" + t3.t.getName() + "' is alive: " + t3.t.isAlive());
        System.out.println("Exiting main thread.");
    }
}