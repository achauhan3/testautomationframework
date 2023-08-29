package non;

class MyThread extends Thread {

    public void run() {
        // Do something in this thread
        System.out.println("Hello from thread " + Thread.currentThread().getName());
    }
}

public class MultithreadingExample {

    public static void main(String[] args) {
        // Create two threads
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        // Start the threads
        thread1.start();
        thread2.start();
    }
}