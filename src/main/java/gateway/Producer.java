package gateway;

import java.util.concurrent.BlockingQueue;

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
                    synchronized (sharedQueue) {
                        sharedQueue.put(i);
                        System.out.println(sharedQueue);
                        sharedQueue.notify();
                        sharedQueue.wait();
                        Thread.sleep(1000);
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

}
