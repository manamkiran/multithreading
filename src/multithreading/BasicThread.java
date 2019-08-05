package multithreading;

public class BasicThread {

	public static void main(String[] args) {
		Runner r = new Runner();
		r.start();
	}

}

class Runner extends Thread {

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
