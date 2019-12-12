package multithreading.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


	class Worker {

		private Lock lock = new ReentrantLock();

		private Condition condition = lock.newCondition();

		public void producer() {
			lock.lock();
			try {
				Thread.sleep(1000);
				System.out.println("Producer.");
				condition.await();
				System.out.println("Producer Again");
			} catch (Exception e) {

			} finally {
				lock.unlock();
			}
		}

		public void consumer() {
			lock.lock();
			try {
				System.out.println("Consumer.");
				Thread.sleep(1000);
				condition.signal();
				System.out.println("Yet to leave the Lock");
			} catch (Exception e) {

			} finally {
				lock.unlock();
			}

		}

	}

public class ProducerConsumerReentrant {

	public static void main(String[] args) {

		Worker w = new Worker();

		Thread t1 = new Thread(() -> w.producer());
		Thread t2 = new Thread(() -> w.consumer());

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (Exception e) {

		}

	}

}
