import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Test3
{
    public static void main(String[] args)
    {
        Runnable barrierAction1 = new Runnable()
        {
            public void run()
            {
                System.out.println("Reached barrier 1");
            }
        };

        Runnable barrierAction2 = new Runnable()
        {
            public void run()
            {
                System.out.println("Reached barrier 2");
            }
        };

        CyclicBarrier cb1 = new CyclicBarrier(2, barrierAction1);
        CyclicBarrier cb2 = new CyclicBarrier(2, barrierAction2);
        Thread t1 = new Thread(new Worker1(cb1, cb2), "worker 1");
        Thread t2 = new Thread(new Worker2(cb1, cb2), "worker 2");
        t1.start();
        t2.start();
        // t1.interrupt();

    }
}

class Worker1 implements Runnable
{

    CyclicBarrier cb1;
    CyclicBarrier cb2;

    Worker1(CyclicBarrier cb1, CyclicBarrier cb2)
    {
        this.cb1 = cb1;
        this.cb2 = cb2;
    }

    public void run()
    {
        try
        {
            Thread.sleep(1000);

            System.out.println(Thread.currentThread().getName() + " Waiting at barrier 1");

            try
            {
                cb1.await(2, TimeUnit.SECONDS);
            }
            catch (TimeoutException e)
            {
                System.out.println(e.getMessage());
            }
            Thread.sleep(1000);

            System.out.println(Thread.currentThread().getName() + " Waiting at barrier 2");
            cb2.await();
        }
        catch (InterruptedException | BrokenBarrierException  e)
        {
            e.printStackTrace();
        }
    }
}

class Worker2 implements Runnable
{

    CyclicBarrier cb1;
    CyclicBarrier cb2;

    Worker2(CyclicBarrier cb1, CyclicBarrier cb2)
    {
        this.cb1 = cb1;
        this.cb2 = cb2;
    }

    public void run()
    {
        try
        {
            try
            {
                Thread.sleep(10000);
            }
            catch (InterruptedException e)
            {
                Thread.sleep(10000);
            }
            System.out.println(Thread.currentThread().getName() + " Waiting at barrier 1");

            cb1.await();

            Thread.sleep(15000);

            System.out.println(Thread.currentThread().getName() + " Waiting at barrier 2");
            cb2.await();
        }
        catch (InterruptedException | BrokenBarrierException e)
        {
            e.printStackTrace();
        }
    }
}
