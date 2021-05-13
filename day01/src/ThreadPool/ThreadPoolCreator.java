package ThreadPool;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadPoolCreator extends Thread {

    private ArrayBlockingQueue<String> repository;

    private boolean isActive;

    private static int testCount = 0;

    public ThreadPoolCreator(ArrayBlockingQueue<String> repository) {
        this.repository = repository;
        this.isActive = true;
    }

    public ThreadPoolCreator(ArrayBlockingQueue<String> repository, String name) {
        if (StringUtils.isNotEmpty(name)) {
            super.setName(name);
            this.repository = repository;
            this.isActive = true;
        } else {
            new IllegalArgumentException();
        }
    }

    @Override
    public void run() {
        while (isActive) {
            String url = getUrl();
             try {
                 if (StringUtils.isNotEmpty(url)) {
                     boolean isSuccess = repository.offer(url, 100, TimeUnit.MILLISECONDS);
                     if (!isSuccess) {
                         //归还url
                     }
                 } else {
                     new IllegalArgumentException();
                     sleep(500);
                 }
             } catch (InterruptedException e) {
                 System.out.println(super.getName() + " has been interrupted");
             }
        }
    }

    private String getUrl() {
        return "URL:XXXXXX/page" + (testCount++) + "/content";
    }

    public void waitForCompletion() {
        isActive = false;
        try {
            this.interrupt();
            this.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(super.getName() + "关闭完成！");
    }
}
