package multithreading.producerconsumer;

/**
 * ProducerConsumer
 */
public class ProducerConsumerProblem {

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
