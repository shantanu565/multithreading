package Mythirdpackage;

public class Ques13 {
    // Coordinate 2 threads using wait() and notify().
    public static void main(String[] args) {

        ThreadA a=new ThreadA();
        ThreadB b = new ThreadB();
        a.start();
        b.start();

        synchronized(b){
            try{
                System.out.println("Waiting for b to complete...");
                b.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("Total is: " + b.vqlue);
        }
    }
}
class ThreadA extends Thread{
    int vqlue;
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<5 ; i++){
                vqlue += i;
            }
            notify();
        }
    }

}
class ThreadB extends Thread{
    int vqlue;
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<5 ; i++){
                vqlue += i;
            }
            notify();
        }
    }

}
