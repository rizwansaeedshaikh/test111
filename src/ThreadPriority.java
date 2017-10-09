
public class ThreadPriority {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Current priority: " + Thread.currentThread().getPriority());
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
		System.out.println("Active threads in current thread's thread groups and it's subgroups: " + Thread.currentThread().getThreadGroup().activeCount());
		Thread t1 = new Thread();
		System.out.println("Active threads in current thread's thread groups and it's subgroups: " + Thread.currentThread().getThreadGroup().activeCount());
		t1.start();
		Thread.sleep(1000); //IF u uncomment sleep, t1 may still be active and activeCount() will return 2.
		//Due to sleep above t1 finishes first and activeCounr() returns 1.
		System.out.println("Active threads in current thread's thread groups and it's subgroups: " + Thread.currentThread().getThreadGroup().activeCount());
	}
}
