package multithreading.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynchronizedBlock {

	private Random r = new Random();

	private Object lock1 = new Object();
	private Object lock2 = new Object();

	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();

	private void step1() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(r.nextInt(100));
		}
	}

	private void step2() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(r.nextInt(100));
		}
	}

	private void doWork() {
		for (int i = 0; i < 1000; i++) {
			step1();
			step2();
		}
	}

	public static void main(String[] args) {
		SynchronizedBlock sb = new SynchronizedBlock();
		sb.mainMethod();

	}

	private void mainMethod() {

		long start = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				doWork();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				doWork();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("Total Time " + (end - start));

		System.out.println("List 1 has " + list1.size() + " items");
		System.out.println("List 2 has " + list2.size() + " items");
	}

}
