package multithreading;

public class DummyThreadCode {
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(() ->  {
			
		});
		Thread t2 = new Thread(() ->  {
			
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (Exception e) {

		}

	}

}
