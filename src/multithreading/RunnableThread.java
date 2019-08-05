package multithreading;

public class RunnableThread {

	public static void main(String[] args) {
		Thread t = new Thread(new RunnableRunner());
		t.start();
	}

}

class RunnableRunner implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
