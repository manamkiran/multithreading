package multithreading.dining.philosopher;

public class DiningPhilosopher {
	
	public static void main(String[] args) {
		ChopStick chop1 = new ChopStick();
		ChopStick chop2 = new ChopStick();
		ChopStick chop3 = new ChopStick();
		ChopStick chop4 = new ChopStick();
		ChopStick chop5 = new ChopStick();
		
		new Philosopher(1, chop1, chop2).start();
		new Philosopher(2, chop2, chop3).start();
		new Philosopher(3, chop3, chop4).start();
		new Philosopher(4, chop4, chop5).start();
		new Philosopher(5, chop5, chop1).start();
	}

}
