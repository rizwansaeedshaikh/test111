import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest
{

    public static void main(String[] args) throws InterruptedException
    {
        CountDownLatch latch = new CountDownLatch(3);
        Thread w = new Thread(new Worker(latch));
        Thread c = new Thread(new Counter(latch));
        
        //w.start();
        c.start();
        latch.await();
        
        System.out.println("Completing");
    }
}

class Worker implements Runnable {
    
    CountDownLatch latch = null;
    
    Worker(CountDownLatch l){
        this.latch = l;
    }
    
    public void run() {
        try
        {
            
            latch.await();
            System.out.println("workers wait over");
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Counter implements Runnable {
    
    CountDownLatch latch = null;
    
    Counter(CountDownLatch l){
        this.latch = l;
    }
    public void run() {
        for (int count = 0; count < 3; count++) {
            try
            {
                //Thread.sleep(1000);
                System.out.println("countingdown");
                latch.countDown();
                
            }
            catch (RuntimeException e)
            {
                e.printStackTrace();
            }
        }
    }
}
