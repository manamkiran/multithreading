package multithreading.dining.philosopher;

import java.util.Random;

public class Philosopher extends Thread {

	private int id;

	private ChopStick left;

	private ChopStick right;

	private Random ranGen = new Random();

	public Philosopher(int id, ChopStick left, ChopStick right) {

		this.id = id;
		this.left = left;
		this.right = right;

	}

	public void think() {
		try {
			System.out.println("Philosopher " + id + " is Thinking");
			Thread.sleep(ranGen.nextInt(10000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eat() {
		if (left.pickUp(id, "left")) {
			if (right.pickUp(id, "right")) {
				System.out.println("Philosopher " + id + " is Eating");
				try {
					Thread.sleep(ranGen.nextInt(10000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					right.putDown(id, "right");
				}
			} else {
				System.out.println("Philosopher " + id + " doesn't have right chopstick. Putting down left chopstick");
			}
			left.putDown(id, "left");
		} else {
			System.out.println("Philosopher " + id + " doesn't have the chopsticks. Going back to thinking");
		}
	}

	@Override
	public void run() {
		while (true) {
			int random = ranGen.nextInt(2);
			if (random % 2 == 0) {
				think();
			} else {
				eat();
			}
			try {
				Thread.sleep(ranGen.nextInt(10000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static enum HAND {
		LEFT, RIGHT;
	}

}
