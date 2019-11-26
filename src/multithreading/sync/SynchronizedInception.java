package multithreading.sync;

public class SynchronizedInception {

	public static void main(String[] args) {
		SynchronizedInception si = new SynchronizedInception();

		new Thread(new Runnable() {

			@Override
			public void run() {
				si.method1();
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				si.method2();
			}
		}).start();
	}

	protected void method1() {
		synchronized (this) {
			System.out.println("Method 1 start");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Method 1 end");
		}
	}

	protected synchronized void method2() {
		System.out.println("Method 2 start");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Method 2 end");
	}

}
