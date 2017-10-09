package threads;

public class Spawner {
	  public static void main(String[] args) {
	    Thread t = new Thread(new Runnable() {
	      public void run() {
	        while (true) {
	          System.out.println("I'm still alive");
	          Thread.yield();
	        }
	      }
	    });
	    // Try uncommenting/commenting this line
	    t.start();
	    //t.setDaemon(true);
	    System.out.println(t.isDaemon());
	    System.out.println("Main thread has finished");
	  }
	}
