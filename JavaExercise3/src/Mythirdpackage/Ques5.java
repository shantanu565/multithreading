package Mythirdpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ques5 {
    //Use isShutDown() and isTerminate() with ExecutorService.
    public static void main(String[] args) {
        ExecutorService es= Executors.newSingleThreadExecutor();
        es.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
            }
        });
        es.shutdownNow();
        System.out.println(es.isShutdown());
        System.out.println(es.isTerminated());


    }
}
