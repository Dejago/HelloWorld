package ThreadPool;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolProject {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> repository = new ArrayBlockingQueue<>(5,true);

        ExecutorService creatorPool = Executors.newSingleThreadExecutor();
        ThreadPoolCreator c1 = new ThreadPoolCreator(repository, "生产者");

        ExecutorService consumerPool = Executors.newFixedThreadPool(5);
        ArrayList<ThreadPoolConsumer> consumers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            consumers.add(new ThreadPoolConsumer(repository, "消费者" + i));
        }

        creatorPool.execute(c1);
        for (ThreadPoolConsumer consumer : consumers) {
            consumerPool.execute(consumer);
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("main Thread has been interrupt");
        }

        creatorPool.shutdown();
        consumerPool.shutdown();
        c1.waitForCompletion();
        for (ThreadPoolConsumer consumer : consumers) {
            consumer.waitForCompletion();
        }
    }
}
