package Mythirdpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ques16 {
    //Create a deadlock and Resolve it using tryLock().
    Lock l1=new ReentrantLock();
    Lock l2=new ReentrantLock();
    public void getLock(Lock l1,Lock l2){
        boolean getlock1=l1.tryLock();
        boolean getlock2=l2.tryLock();

        if (getlock1 &&getlock2){
            return;
        }
        if (getlock1){
            l1.unlock();
        }
        if (getlock2){
            l2.unlock();
        }
    }
    public  void w1(){
        getLock(l1,l2);
        System.out.println("w1 get l1 & l2");
        try {
            l2.unlock();
            l1.unlock();
        }catch (Exception e){
            System.out.println("Unlocking error in l1");
        }
    }
    public  void w2(){
        getLock(l1,l2);
        System.out.println("w2 get l1 & l2");
        try {
            l1.unlock();
            l2.unlock();
        }catch (Exception e){
            System.out.println("Unlocking error in l1");
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Ques16 q6=new Ques16();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                q6.w1();
            }
        });
      Thread t2=new Thread(new Runnable() {
          @Override
          public void run() {
              q6.w2();
          }
      });
      t1.start();
      t2.start();
      t1.join();
        t2.join();

    }
}
