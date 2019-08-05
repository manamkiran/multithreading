package multithreading.sync;

public class SynchronizedMethod {

	private int counter;

	public static void main(String[] args) {
		SynchronizedMethod sm = new SynchronizedMethod();
		sm.doWork();
	}

	private synchronized void incrementCounter() {
		counter++;
	}

	private void doWork() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					incrementCounter();
				}
			}
		});

		t1.start();

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					incrementCounter();
				}
			}

		});

		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(counter);
	}

}
