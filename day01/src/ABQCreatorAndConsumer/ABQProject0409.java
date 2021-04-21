package ABQCreatorAndConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class ABQProject0409 {

    public static void main(String[] args) {

        ArrayBlockingQueue<String> repository = new ArrayBlockingQueue<>(5,false);
        List<ABQCreator0409> creators = new ArrayList<>();
        List<ABQConsumer0409> consumers = new ArrayList<>();
        creators.add(new ABQCreator0409(repository, "生产者1"));
        for (int i = 0; i < 5; i++) {
            consumers.add(new ABQConsumer0409(repository, "消费者" + (i + 1)));
        }

        for (ABQCreator0409 creator : creators) {
            creator.start();
        }

        //阻塞3秒可以制造延迟
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (ABQConsumer0409 consumer : consumers) {
            consumer.start();
        }

        //阻塞10秒后开始关闭程序
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("开始关闭生产者...");
        for (ABQCreator0409 creator : creators) {
            creator.closingSystem();
        }
        System.out.println("开始关闭消费者...");
        for (ABQConsumer0409 consumer : consumers) {
            consumer.closingSystem();
        }



    }
}
