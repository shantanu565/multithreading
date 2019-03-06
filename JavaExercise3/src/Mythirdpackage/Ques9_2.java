package Mythirdpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Ques9_2 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        ThreadPoolExecutor pool = (ThreadPoolExecutor) es;
        es.submit(new Task2());
        es.submit(new Task2());
        es.shutdown();
    }

}
 class Task2 implements Runnable {

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

