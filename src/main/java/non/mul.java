package non;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MultithreadingExample1 {

    public static void main(String[] args) {
        // Create an executor service
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Create two tasks
        Runnable task1 = () -> System.out.println("This is thread 1" + Thread.currentThread().getName());

        Runnable task2 = () -> System.out.println("This is thread 2" + Thread.currentThread().getName());

        // Submit the tasks to the executor service
        executorService.submit(task1);
        executorService.submit(task2);

        // Shutdown the executor service
        executorService.shutdown();
    }
}
