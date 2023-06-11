package gateway;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainThread {
    static final BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>(3);

    public static void main(String[] args) {
        System.out.println("Начался основной поток");

        Thread consumer_thread = new Thread(new Consumer(sharedQueue));
        Thread producer_thread = new Thread(new Producer(sharedQueue));
        consumer_thread.start();
        producer_thread.start();
    }
}