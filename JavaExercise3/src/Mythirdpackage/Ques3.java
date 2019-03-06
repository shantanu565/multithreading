package Mythirdpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ques3 {
    //Use a singleThreadExecutor to submit multiple threads.
    public static void main(String[] args) {
        ExecutorService es= Executors.newSingleThreadExecutor();
        try{
            es.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("T1");
                }
            });
            es.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("T2");
                }
            });
        }finally {
            es.shutdownNow();
        }
        System.out.println(es.isShutdown());
        System.out.println(es.isTerminated());

        }
    }
