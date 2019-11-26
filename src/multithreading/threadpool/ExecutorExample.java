package multithreading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(2);
	
		for (int i = 0; i < 5; i++) {
			exec.submit(new Runner(i));
		}
		
		exec.shutdown();
		
		System.out.println("All Tasks submitted");
		try {
			exec.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Exiting Main Program");
	}

}

class Runner implements Runnable {

	private int id;

	public Runner(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Starting Thread " + id);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Completed Thread " + id);
	}

}
