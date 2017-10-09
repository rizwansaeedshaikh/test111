package test;

public class Database
{

    private DBStatus dbStatus;

    public Database(DBStatus dbStatus)
    {
        this.dbStatus = dbStatus;
    }

    public void process()
    {
        synchronized (dbStatus)
        {
            System.out.println("Creating db connection");
            try
            {
                Thread.sleep(10000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            this.dbStatus.setReady(true);
            System.out.println("Database is notifying everyone waiting on dbstatus lock");
            dbStatus.notifyAll();
        }
        
    }
}
