package Mythirdpackage;

//    //Use sleep and join methods with thread
public class Ques2 extends Thread
{
    public void run()
    {
        System.out.println("running ");
        try {
            Thread.sleep(530);
        }catch(InterruptedException ie){ }
        System.out.println("sec running ");
    }
    public static void main(String[] args)
    {
        Ques2 t1=new Ques2();
        Ques2 t2=new Ques2();
        t1.start();

        try{
            t1.join();
        }catch(InterruptedException ie){}

        t2.start();
    }
}


