import java.util.concurrent.ArrayBlockingQueue;

public class ABQCreator0409 extends Thread {

    private ArrayBlockingQueue<String> repository;
    private boolean isActive;

    //this number is used for debugging
    private static int testCount;

    public ABQCreator0409(ArrayBlockingQueue<String> repository) {
        this(repository,null);
    }

    public ABQCreator0409(ArrayBlockingQueue<String> repository, String name) {
        this.repository = repository;
        if (name != null)
            super.setName(name);
        isActive = true;
        testCount = 0;
    }

    @Override
    public void run() {
        while(isActive) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(super.getName() + " has been interrupted!!!!!");
            }
            String url = getUrl();
            try {
                repository.put(url);
            } catch (InterruptedException e) {
                System.out.println(super.getName() + " has been interrupted!!!!!");
            }

            //debug 控制数量
            if (testCount >= 20) {
                isActive = false;
                System.out.println("生产者完成");
            }
        }
    }

    private String getUrl() {
        return "URL:XXXXXX/page" + testCount++ + "/content";
    }

    public void closingSystem() {
        isActive = false;
        this.interrupt();
        try {
            this.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(super.getName() + "关闭完成！");
    }


}
