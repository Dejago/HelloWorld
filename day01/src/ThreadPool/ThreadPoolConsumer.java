package ThreadPool;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadPoolConsumer extends Thread {

    private ArrayBlockingQueue<String> repository;

    private boolean isActive;

    //系统分隔符
    private static final String SEPARATOR = File.separator;

    // D:\\AQB\\
    private static final String FILE_CONTEXT = "D:" + SEPARATOR + "AQB" + SEPARATOR;

    private static int testCount;

    public ThreadPoolConsumer(ArrayBlockingQueue<String> repository) {
        this.repository = repository;
        this.isActive = true;
    }

    public ThreadPoolConsumer(ArrayBlockingQueue<String> repository, String name) {
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
        int serial = 1;

        while (isActive) {
            try {
                String url = repository.poll(100, TimeUnit.MILLISECONDS);
                boolean isSuccess = urlHandle(serial, url);
                if (isSuccess) {
                    serial++;
                }
            } catch (InterruptedException e) {
                System.out.println(super.getName() + " has been interrupted");
            } catch (IllegalArgumentException e) {
                //如果url为空串时所做的处理
            }
        }
    }

    private boolean urlHandle(int serial, String url) {
        if (StringUtils.isNotEmpty(url)) {
            String content = this.getContent(url);
            String fileDirectory = this.fileDirectory();
            String fileName = this.filename(serial);
            this.download(fileDirectory, fileName, content);
            return true;
        } else {
            new IllegalArgumentException();
            return false;
        }
    }

    private String fileDirectory() {
        return FILE_CONTEXT + super.getName();
    }

    private String filename(int serial) {
        return "url" + serial + ".txt";
    }

    private boolean download(String fileDirectory, String fileName, String content) {
        File filePath = new File(fileDirectory);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }

        File file = new File(filePath + SEPARATOR + fileName);

        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            System.out.println("文件已输出：" + file.getAbsolutePath()); //debug
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String getContent(String url) {
        return url + " || Content:" + testCount;
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
