package Mythirdpackage;


class MyThread2 extends Thread
{
    public void run()
    {
        System.out.println(" thread started running  from class");
    }
}


public class Ques1_secpart {
    public static void main( String args[] )
    {
        MyThread2 mt = new  MyThread2();
        mt.start();
    }
}
