import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThreadProCumTest {
    public static void main(String[] args) {

        List<String> cargo = new ArrayList<>();
        Object lock = new Object();

        int creatorNum = 5;
        int consumerNum = 10;

        List<ThreadCreator0328> creators = new LinkedList<>();
        for (int i = 0; i < creatorNum; i++) {
            creators.add(new ThreadCreator0328(cargo, lock));
        }

        List<ThreadConsumer0328> consumers = new LinkedList<>();
        for (int i = 0; i < consumerNum; i++) {
            consumers.add(new ThreadConsumer0328(cargo, lock));
        }

        Thread[] creatorGroup = new Thread[creatorNum];
        Thread[] consumerGroup = new Thread[consumerNum];

        int n = 0;
        for (ThreadCreator0328 creator : creators) {
            Thread creatorThread = new Thread(creator, "生产者" + (n + 1));
            creatorThread.start();
            creatorGroup[n] = creatorThread;
            n++;
        }

        n = 0;
        for (ThreadConsumer0328 consumer : consumers) {
            Thread consumerThread = new Thread(consumer ,"消费者" + (n + 1));
            consumerThread.start();
            consumerGroup[n] = consumerThread;
            n++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //全部创建完毕，10秒后关闭
        int time = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time++;
            if (time >= 10) {
                System.out.println("正在中止");
                for (ThreadCreator0328 creator : creators) {
                    creator.setActive(false);
                }
                for (ThreadConsumer0328 consumer : consumers) {
                    consumer.setActive(false);
                }
                for (Thread creator : creatorGroup) {
                    try {
                        creator.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (Thread consumer : consumerGroup) {
                    try {
                        consumer.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("中止完成");
                break;
            }
        }

        /*for (int i = 0; i < creatorNum; i++) {
            creatorGroup[i] = new Thread(new ThreadCreator0328(cargo, lock),"生产者" + (i + 1));
        }*/

        /*for (Thread creator : creatorGroup) {
            creator.start();
        }*/



        /*for (int i = 0; i < consumerNum; i++) {
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
        }*/

    }
}
