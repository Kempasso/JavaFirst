package gateway;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainThread {
    static final BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>(5);

    public static void main(String[] args) {
        System.out.println("Начался основной поток");

        Thread consumer_thread = new Thread(new Consumer(sharedQueue));
        Thread producer_thread = new Thread(() -> {
            Producer dataGenerator = new Producer(sharedQueue);
            dataGenerator.generateIntData();
        });
        producer_thread.start();
        consumer_thread.start();

        try {
            consumer_thread.join();
            producer_thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Основной поток завершился");
    }
}