import java.util.LinkedList;

public class ThreadTest1
{

    public static void main(String[] args)
    {
        
        final ProducerConsumer pc = new ProducerConsumer();
        
        Thread t1 = new Thread(new Runnable()
        {
            
            @Override
            public void run()
            {
                pc.produce();
            }
        }, "producer");
        
        Thread t2 = new Thread(new Runnable()
        {
            
            @Override
            public void run()
            {
               pc.consume(); 
            }
        }, "consumer"); 
        
        t1.start();
        t2.start();
    }

    private static class ProducerConsumer
    {

        private LinkedList<Integer> list = new LinkedList<>();
        private static final int capacity = 10;

        private void produce()
        {
            int value = 0;
            
            while (true)
            {

                synchronized (this)
                {
                    if(list.size() == capacity) {
                        System.out.println("Producer capacity reached. Waiting...");
                        try
                        {
                            wait();
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    value++;
                    System.out.println("Producer produced " + value);
                    list.add(value);
                    
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    
                    notify();
                }
            }
        }

        private void consume()
        {

            while (true)
            {

                synchronized (this)
                {
                    if(list.size() == 0) {
                        System.out.println("Consumer consumed everything. Waiting...");
                        try
                        {
                            wait();
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    
                    System.out.println("Consumer consumed " + list.removeFirst());
                    
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    
                    notify();
                }
            }
        }
    }
}
