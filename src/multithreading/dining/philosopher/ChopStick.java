package multithreading.dining.philosopher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {

	private final Lock lock = new ReentrantLock(true);
	
	public boolean pickUp(int id,String side ) {
		try {
			if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
				System.out.println("Philosopher "+ id+ " took " + side + "chopstick");
				return true;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void putDown(int id,String side ) {
		lock.unlock();
		System.out.println("Philosopher "+ id+ " putDown " + side + "chopstick");
		
	}
	

}
