package Mythirdpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ques4 {
    //Try shutdown() and shutdownNow() and observe the difference.
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
                    try {
                        Thread.sleep(5000L);
                    }catch (InterruptedException e){
                        System.out.println("sleep error");
                    }

                    System.out.println("T2");
                }
            });
        }finally {
            es.shutdown();
        }
        System.out.println(es.isShutdown());
        System.out.println(es.isTerminated());

    }
}
