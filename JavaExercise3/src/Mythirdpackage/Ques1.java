package Mythirdpackage;

class MyThread implements Runnable
{
    //Create and Run a Thread using Runnable Interface and Thread class.
    public void run()
    {
        System.out.println("thread started ");
    }
}


public class Ques1 {
    //Create and Run a Thread using Runnable Interface and Thread class
    public static void main( String args[] )
    {
        MyThread mt = new MyThread();
        Thread t = new Thread(mt);
        t.start();
    }
}
