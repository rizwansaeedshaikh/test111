import java.util.concurrent.Exchanger;

public class Test4
{

    public static void main(String[] args)
    {
        Exchanger<String> exchanger = new Exchanger<>();
        Thread t1 = new Thread(new Worker3(exchanger,"A"), "thread 1");
        Thread t2 = new Thread(new Worker4(exchanger,"B"), "thread 2");
        
        t1.start();
        t2.start();
    }
}
class Worker3 implements Runnable {
    
    Exchanger<String> exchanger;
    String object;
    
    Worker3(Exchanger<String> exchanger, String object){
        this.exchanger = exchanger;
        this.object = object;
    }
    
    public void run() {
        
        try
        {
            System.out.println(Thread.currentThread().getName() + " before exchanging " + object);
            Thread.sleep(4000);
            object = this.exchanger.exchange(object);
            System.out.println(Thread.currentThread().getName() + " after exchanging " + object);
            object = this.exchanger.exchange(object);
            System.out.println(Thread.currentThread().getName() + " after exchanging " + object);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
class Worker4 implements Runnable {
    
    Exchanger<String> exchanger;
    String object;
    
    Worker4(Exchanger<String> exchanger, String object){
        this.exchanger = exchanger;
        this.object = object;
    }
    
    public void run() {
        
        try
        {
            System.out.println(Thread.currentThread().getName() + " before exchanging " + object);
            //Thread.sleep(4000);
            object = this.exchanger.exchange(object);
            System.out.println(Thread.currentThread().getName() + " after exchanging " + object);
            Thread.sleep(4000);
            object = this.exchanger.exchange(object);
            System.out.println(Thread.currentThread().getName() + " after exchanging " + object);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
