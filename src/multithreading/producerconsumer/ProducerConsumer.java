package multithreading.producerconsumer;

/**
 * ProducerConsumer
 */
public class ProducerConsumer {

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer Method");
            wait();
            System.out.println("Again Producer Method");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(1000);

        synchronized (this) {
            System.out.println("Consumer Method");
            notify();
            System.out.println("Done for now");
            Thread.sleep(3000);
        }
        Thread.sleep(1000);
        System.out.println("Still Going On ???");
        Thread.sleep(3000);
        System.out.println("### Still Going On ???");
        synchronized (this) {
            System.out.println("Consumer Method Part 2");
            System.out.println("Done for now Part 2");
        }

    }

    public static void main(String[] args) {

        ProducerConsumer producer = new ProducerConsumer();

        new Thread(() -> {
            try {
                producer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                producer.consume();
            } catch (InterruptedException e) {
            }
        }).start();

    }

}
