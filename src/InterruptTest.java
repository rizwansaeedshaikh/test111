
public class InterruptTest
{

    public static void main(String[] args)
    {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try
                {
                    Thread.sleep(10000);
                }
                catch (InterruptedException e)
                {
                    System.out.println("interrupted");
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t1.interrupt();
    }

}
