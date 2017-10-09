package threads;

import java.util.ArrayList;
import java.util.List;

public class SimpleThread {

	public static void main(String[] args) throws InterruptedException {
		
		List<String> list = new ArrayList<String>(10);
		
		for(int count = 0; count < 10; count++){
			list.add(count, null);
		}
		Account account = new Account();
		MyThread myThread1 = new MyThread("thread 1", list, account);
		MyThread myThread2 = new MyThread("thread 2", list, account);
		MyThread myThread3 = new MyThread("thread 3", list, account);
		MyThread myThread4 = new MyThread("thread 4", list, account);
		System.out.println(Thread.currentThread().getName());
		myThread1.start();
		myThread2.start();
		myThread3.start();
		myThread4.start();
	}
}

class MyThread extends Thread {
	
	List<String> list;
	Account account;
	
	public MyThread() {
		
	}
	
	public MyThread(String name, List<String> list, Account account){
		super(name);
		this.list = list;
		this.account = account;
	}
	
	public void run(){
		
		for(int count = 0; count < 10; count++){
			System.out.println(count + " " + Thread.currentThread().getName());
			//if(list.size() - 1 <= count)
				//list.add(count, Thread.currentThread().getName());
			//else
			if(list.get(count) == null)
				list.set(count, getName());
		}
		try
        {
            account.withdraw(10);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		System.out.println(Thread.currentThread().getName() +  " " + list);
		System.out.println(account.getBalance());
	}
}

class Account{
    
    private int balance = 100;

    public synchronized int getBalance()
    {
        System.out.println("getBalance " + Thread.currentThread().getName());
        return balance;
    }

    public synchronized void setBalance(int balance)
    {
        System.out.println("setBalance " + Thread.currentThread().getName() + " " + balance);
        this.balance = balance;
    }
    
    public synchronized void withdraw(int amount) throws InterruptedException{
        
        int bal = getBalance() - amount;
        setBalance(bal);
        System.out.println("withdraw " + Thread.currentThread().getName() + " " + balance + " " + amount);
    }
    
}
