package gateway;

import java.util.concurrent.BlockingQueue;

public class Producer {
    private final BlockingQueue<Integer> sharedQueue;

    public Producer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    public void generateIntData() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                try {
                    sharedQueue.put(i);
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

