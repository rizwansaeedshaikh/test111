import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Test5 {

	private static ExecutorService executorService = Executors.newFixedThreadPool(2);
	private static ScheduledThreadPoolExecutor s = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);
	private static volatile Future<Integer> taskOneResult = null;
	private static volatile Future<Integer> taskTwoResult = null;

	public static void main(String[] args) {

		while (true) {
			try {
				checkTasks();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Task2 interrupted. Message: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Exception in main's infinite loop. " + e.getMessage());
			}
		}
	}

	private static void checkTasks() {
		if (taskOneResult == null || taskOneResult.isDone() || taskOneResult.isCancelled()) {
			if(taskOneResult != null && taskOneResult.isDone()) {
				try {
					System.out.println("Task 1 returned: " + taskOneResult.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
			taskOneResult = executorService.submit(new Task1(), 0);
		}
		if (taskTwoResult == null || taskTwoResult.isDone() || taskTwoResult.isCancelled()) {
			if(taskTwoResult != null && taskTwoResult.isDone()) {
				try {
					System.out.println("Task 2 returned: " + taskTwoResult.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
			taskTwoResult = executorService.submit(new Task2(), 0);
		}
	}

	private static class Task2 implements Runnable {

		@Override
		public void run() {

			System.out.println("Executing task2 in " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Task2 interrupted. Message: " + e.getMessage());
			}
			System.out.println("Returning from task2");
		}
	}

	private static class Task1 implements Runnable {

		@Override
		public void run() {

			System.out.println("Executing task1 " + Thread.currentThread().getName());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("Task1 interrupted. Message: " + e.getMessage());
			}
			System.out.println("Returning from task1");
		}
	}
}
