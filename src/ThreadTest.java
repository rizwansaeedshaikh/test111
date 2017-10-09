import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
 
public class ThreadTest
{
    public static void main(String[] args)
                        throws InterruptedException, FileNotFoundException
    {
       
        // Object of a class that has both produce()
        // and consume() methods
        final PC pc = new PC();
 
        // Create producer thread
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    pc.produce();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        },"t1");
 
        // Create consumer thread
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    pc.consume();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        },"t2");
        
     // Create consumer thread
        Thread t3 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    pc.consume();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        },"t3");
        
     // Create consumer thread
        Thread t4 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    pc.consume();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        },"t4");
 
        // Start both threads
        t1.start();
        t2.start();
        //t3.start();
        //t4.start();
 
        // t1 finishes before t2
        t1.join();
        t2.join();
    }
 
    // This class has a list, producer (adds items to list
    // and consumber (removes items).
    public static class PC
    {
        // Create a list shared by producer and consumer
        // Size of list is 2.
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 10;
 
        // Function called by producer thread
        public void produce() throws InterruptedException
        {
            int value = 0;
            while (true)
            {
                synchronized (list)
                {
                    // producer thread waits while list
                    // is full
                    if (list.size()==capacity) {
                        System.out.println("Producer " + Thread.currentThread().getName() +" waiting");
                        list.wait();
                    } else
                        list.notify();
                    
                 // to insert the jobs in the list
                    list.add(value++);
                    
                    System.out.println("Producer  " + Thread.currentThread().getName() + " produced-"
                                                  + value + " " + list.size());
 
                    
                    
                    if(value == 1000)
                        System.exit(0);
 
                    // notifies the consumer thread that
                    // now it can start consuming
                    //list.notify();
 
                    // makes the working of program easier
                    // to  understand
                    //Thread.sleep(1000);
                }
            }
        }
 
        // Function called by consumer thread
        public void consume() throws InterruptedException
        {
            while (true)
            {
                synchronized (list)
                {
                    // consumer thread waits while list
                    // is empty
                    if (list.size()==0) {
                        System.err.println("Consumer " + Thread.currentThread().getName() + " waiting");
                        list.wait();
                    } else
                        list.notify();
                    
                    //to retrive the ifrst job in the list
                    int val = list.removeFirst();
 
                    System.err.println("Consumer  " + Thread.currentThread().getName() + "  consumed-"
                                                    + val + " " + list.size());
 
                    // Wake up producer thread
                    //list.notify();
 
                    // and sleep
                    //Thread.sleep(1000);
                }
            }
        }
    }
}