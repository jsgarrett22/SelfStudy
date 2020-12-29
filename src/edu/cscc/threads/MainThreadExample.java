package edu.cscc;

/** Demonstrates the main thread and how to capture it and manipulate */

public class MainThreadExample {
    public static void main(String[] args) throws InterruptedException {

        // This is a way to select the main thread
        Thread t = Thread.currentThread();

        System.out.println("Current thread is: " + t.getName());

        // Change name of thread
        t.setName("Joshua's Thread");
        System.out.println("Current thread is: " + t.getName());

        // Demonstrates the sleep method of a thread
        for (int i = 0; i <= 50; i++) {
            System.out.println(i);
            Thread.sleep(2000);
        }
    }
}
