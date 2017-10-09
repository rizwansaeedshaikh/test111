
public class JoinTest
{

    public static void main(String[] args) throws InterruptedException
    {
        Runnable r1 = new Runnable()
        {

            @Override
            public void run()
            {
                System.out.println(Thread.currentThread().getName());
                try
                {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        };

        Runnable r2 = new Runnable()
        {

            @Override
            public void run()
            {
                System.out.println(Thread.currentThread().getName());
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        };

        Thread t1 = new Thread(r1, " t1");
        Thread t2 = new Thread(r2, " t2");

        t1.start();
        t2.start();
        
        t1.join();
        System.out.println("Thread 1 done");
        t2.join();
        System.out.println("Thread 2 done");
    }
}
