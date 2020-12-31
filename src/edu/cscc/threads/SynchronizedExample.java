package edu.cscc.threads;

/**
 * Demonstrates synchronization and interprocess communication between threads using wait and notify
 */
public class SynchronizedExample {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Producer producer = new Producer(inventory);
        Consumer consumer = new Consumer(inventory);

        producer.t.start();
        consumer.t.start();

        System.out.println("Press Control-C to stop.");
    }
}

/** Demonstrates an inventory with a quantity amount */
class Inventory {
    int quantity;
    boolean valueSet = false;

    /** Returns a value */
    synchronized int get() {
        while (valueSet == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught.");
            }
        }
        System.out.println("Got: " + quantity);
        valueSet = false;
        notify();
        return quantity;
    }

    /** Puts a value into the instance */
    synchronized void put(int n) {
        while (valueSet == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        this.quantity = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }
}

/** Class that produces a value constantly and puts it into an inventory instance */
class Producer implements Runnable {

    Inventory inv;
    Thread t;

    Producer(Inventory inv) {
        this.inv = inv;
        t = new Thread(this, "Producer");
    }

    @Override
    public void run() {
        int i = 0;

        while(true) {
            inv.put(i++);
        }
    }
}

/** Class that takes a value away constantly from an inventory instance */
class Consumer implements Runnable {

    Inventory inv;
    Thread t;

    Consumer(Inventory inv) {
        this.inv = inv;
        t = new Thread(this, "Consumer");
    }

    @Override
    public void run() {
        while(true) {
            inv.get();
        }
    }
}
