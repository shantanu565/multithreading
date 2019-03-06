package Mythirdpackage;

 class Book1 {
    //Use Synchronize block to enable synchronization between multiple threads trying to access method at same time.
    void getBook1(int n){
        synchronized(this){
            for(int i=1;i<=n;i++){
                System.out.println("Thread" +i);
                try{
                    Thread.sleep(400);
                }catch(Exception e){System.out.println(e);}
            }
        }
    }


}
class Reader2 extends Thread
{

    Book1 book;

    Reader2(Book1 book1){
        this.book=book1;
    }


    @Override
    public void run()
    {
        book.getBook1(2);
    }
}

public class Ques11{
    public static void main(String[] args) {

        Book1 obj1 = new Book1();
        Reader2 r1=new Reader2(obj1);
        Reader2 r2 =new Reader2(obj1);

        r1.start();
        r2.start();
    }
}
