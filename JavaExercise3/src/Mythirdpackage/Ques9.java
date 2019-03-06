package Mythirdpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Ques9 {
    //Increase concurrency with Thread pools using newCachedThreadPool() and newFixedThreadPool()
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        ThreadPoolExecutor pool = (ThreadPoolExecutor) es;


        es.submit(new Task());
        es.submit(new Task());
        es.shutdown();

    }

}
 class Task implements Runnable {

    public void run() {

        try {
            Long duration = (long) (Math.random() * 5);
            System.out.println("Running Task! Thread Name: " +
                    Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(duration);

            System.out.println("Task Completed! Thread Name: " +
                    Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
