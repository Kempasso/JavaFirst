package gateway;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class Producer implements Runnable {
    private final BlockingQueue<Integer> sharedQueue;

    public Producer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        System.out.println("Запуск потока producer");
        while (true) {
            int i = 0;
            for (; i < 5; i++) {
                try {
                    sharedQueue.put(i);
                    System.out.println(sharedQueue);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

}
