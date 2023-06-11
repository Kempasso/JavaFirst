package gateway;

import java.util.concurrent.BlockingQueue;

import static gateway.MainThread.sharedQueue;

public class Consumer implements Runnable {
    private BlockingQueue<Integer> sharedQueue;

    @Override
    synchronized public void run() {
        System.out.println("Запуск потока consumer");
        int i = 0;
        while (true) {
            try {
                int value = sharedQueue.take();
                wait(300);
                System.out.println(value);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Consumer " + i);
        }
    }



    public Consumer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
}

