package ABQCreatorAndConsumer;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;


public class ABQCreator0409 extends Thread {

    private ArrayBlockingQueue<String> repository;

    private boolean isActive;

    //this number is used for debugging
    private static int testCount = 0;

    public ABQCreator0409(ArrayBlockingQueue<String> repository) {
        this.repository = repository;
        this.isActive = true;
    }

    public ABQCreator0409(ArrayBlockingQueue<String> repository, String name) {
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
        while(isActive) {
            String url = getUrl();

            try {
                if (StringUtils.isNotEmpty(url)) {
                    boolean isSuccess = repository.offer(url, 100, TimeUnit.MILLISECONDS);
                    if (!isSuccess) {
                        //1.丢弃不管

                        //2.归还机制
                        //handleError() 处理异常
                    }
                } else {
                    new IllegalArgumentException();
                    sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println(super.getName() + " has been interrupted!!!!!");
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
