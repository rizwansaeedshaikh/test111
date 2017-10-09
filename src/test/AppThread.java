package test;

public class AppThread implements Runnable
{

    
    private Application application;

    public AppThread(Application application)
    {
        this.application = application;
    }

    public void run()
    {

        //this process will run for the lifetime of the application
        //so the while(true) block goes in process
        application.process();
    }
}
