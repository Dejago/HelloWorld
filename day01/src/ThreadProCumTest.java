import java.util.ArrayList;
import java.util.List;

public class ThreadProCumTest {
    public static void main(String[] args) {

        List<String> cargo = new ArrayList<>();
        Object lock = new Object();
        Boolean isActive = true;

        int creatorNum = 5;
        int consumerNum = 10;


        Thread[] creatorGroup = new Thread[creatorNum];
        Thread[] consumerGroup = new Thread[consumerNum];

        for (int i = 0; i < creatorNum; i++) {
            creatorGroup[i] = new Thread(new ThreadCreator0328(cargo, lock),"生产者" + (i + 1));
        }

        for (Thread creator : creatorGroup) {
            creator.start();
        }

        for (int i = 0; i < consumerNum; i++) {
            consumerGroup[i] = new Thread(new ThreadConsumer0328(cargo, lock),"顾客" + (i + 1));
        }

        int count = 0;
        for (Thread consumer : consumerGroup) {
            //循环生成8次后中止所有线程
            try {
                if (count == 8) {
                    System.out.println("中断");
                    for (Thread creator : creatorGroup) {
                        creator.interrupt();
                    }
                    for (Thread con : consumerGroup) {
                        con.interrupt();
                    }
                    break;
                }
                consumer.start();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }

    }
}
