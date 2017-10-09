package test;

public class Main
{

    public static void main(String[] args)
    {
        DBStatus dbStatus = new DBStatus();
        
        DBThread dbThread = new DBThread(new Database(dbStatus));
        AppThread appThread = new AppThread(new Application(dbStatus));
        
        Thread dbT = new Thread(dbThread);
        Thread appT = new Thread(appThread);
        appT.setPriority(10);
        
        appT.start();
        dbT.start();
        
    }
}
