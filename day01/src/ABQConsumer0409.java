import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;

public class ABQConsumer0409 extends Thread{

    private ArrayBlockingQueue<String> repository;
    private String name;
    private boolean isActive;
    private static final String SEPARATOR = File.separator;
    // D:\\AQB\\
    private static final String FILE_CONTEXT = "D:" + SEPARATOR + "AQB" +SEPARATOR;

    //this number is used for debugging
    private static int testCount;

    public ABQConsumer0409(ArrayBlockingQueue<String> repository) {
        this(repository,null);
    }

    public ABQConsumer0409(ArrayBlockingQueue<String> repository, String name) {
        this.repository = repository;
        if (name != null)
            super.setName(name);
        isActive = true;
    }

    @Override
    public void run() {
        int serial = 1;
        while (isActive) {
            String url = null;
            try {
                url = repository.take();  //从仓库中取出URL
                System.out.println(super.getName() + "取出URL：" + url); //debug
            } catch (InterruptedException e) {
                System.out.println(super.getName() + " has been interrupted!!!!!");
            }
            String content = getContent(url);  //把取出的url传入对应的方法中，从而获取内容
            System.out.println(super.getName() + "获得内容：" + content);  //debug

            String fileDirectory = FILE_CONTEXT + super.getName();
            String fileName = serial++ + ".txt";
            File filePath = new File(fileDirectory);
            if (!filePath.exists())
                filePath.mkdirs();
            File file = new File(filePath + SEPARATOR + fileName);
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                fw.write(content);
                System.out.println("文件已输出：" + file.getAbsolutePath()); //debug
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private String getContent(String url) {
        return url + " || Content:" + testCount;
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
