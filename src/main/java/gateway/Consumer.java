package gateway;

import java.util.concurrent.BlockingQueue;


public class Consumer implements Runnable {
    private final BlockingQueue<Integer> sharedQueue;

    public Consumer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
    @Override
    public void run() {
        System.out.println("Запуск потока consumer");
        while (true) {
            try {
                synchronized (sharedQueue) {
                    int value = sharedQueue.take();
                    System.out.println(sharedQueue);
                    System.out.println(value);
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

