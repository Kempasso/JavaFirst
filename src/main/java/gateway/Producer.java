package gateway;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<Integer> sharedQueue;

    @Override

    synchronized public void run() {
        System.out.println("Start producer thread");
        while (true) {
            int i = 0;
            for (; i < 5; i++) {
                try {
                    sharedQueue.put(i);
                    System.out.println(sharedQueue);
                    wait(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//                System.out.println("Prosucer " + i);
            }
        }
    }

    public Producer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

}
