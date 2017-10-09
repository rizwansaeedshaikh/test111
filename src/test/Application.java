package test;

public class Application
{
    private DBStatus dbStatus;

    public Application(DBStatus dbStatus)
    {
        this.dbStatus = dbStatus;
    }

    public void process()
    {

        synchronized (dbStatus)
        {
            if (!dbStatus.isReady())
                try
                {
                    System.out.println("AppThread going into wait state");
                    dbStatus.wait();
                    System.out.println("Appthread's wait is over");
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
        }
        System.out.println("Application started processing");
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Application finished processing");
    }
}
