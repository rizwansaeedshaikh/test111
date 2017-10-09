package test;

public class DBThread implements Runnable{

    Database database;
    
    public DBThread(Database database)
    {
        this.database = database;
    }
    
    public void run(){
    
        database.process();
    }
}
