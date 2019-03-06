package Mythirdpackage;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ques15 {
    // Use Reentract lock for coordinating 2 threads with signal(), signalAll() and wait().
    Lock l1 = new ReentrantLock();
    Condition c1 = l1.newCondition();

    public void w1(){
        l1.lock();
        System.out.println("w1 ");
        try {
            c1.await();
            System.out.println("w1 done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            l1.unlock();
        }

    }
  public void w2(){
        try {
            l1.lock();
            System.out.println("w2");
            System.out.println("w2 done");
            c1.signal();
        }finally {
            l1.unlock();
        }

  }

    public static void main(String[] args) throws InterruptedException {
        Ques15 q=new Ques15();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                q.w1();
            }
        });
       Thread t2=new Thread(new Runnable() {
           @Override
           public void run() {
               q.w2();
           }
       });
       t1.start();
       t2.start();
       t1.join();
       t2.join();
    }


}
