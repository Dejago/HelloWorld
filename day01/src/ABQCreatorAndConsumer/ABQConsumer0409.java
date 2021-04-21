package ABQCreatorAndConsumer;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ABQConsumer0409 extends Thread{

    private ArrayBlockingQueue<String> repository;

    private boolean isActive;

    private static final String SEPARATOR = File.separator;

    // D:\\AQB\\
    private static final String FILE_CONTEXT = "D:" + SEPARATOR + "AQB" +SEPARATOR;

    //this number is used for debugging
    private static int testCount;

    public ABQConsumer0409(ArrayBlockingQueue<String> repository) {
        this.repository = repository;
        this.isActive = true;
    }

    public ABQConsumer0409(ArrayBlockingQueue<String> repository, String name) {
        if(StringUtils.isEmpty(name)) {
            super.setName(name);
            this.repository = repository;
            this.isActive = true;
        }else {
            new IllegalArgumentException();
        }
    }

    @Override
    public void run() {
        int serial = 1;

        while (isActive) {
            try {
                String url = repository.poll(100, TimeUnit.MILLISECONDS);  //从仓库中取出URL
                //System.out.println(super.getName() + "取出URL：" + url); //debug
                urlHandle(serial++, url);
            } catch (InterruptedException e) {
                System.out.println(super.getName() + " has been interrupted!!!!!");
            }
        }
    }

    private void urlHandle(int serial, String url) {
        if (url != null && !url.isEmpty()) {
            String content = getContent(url);  //把取出的url传入对应的方法中，从而获取内容
            //System.out.println(super.getName() + "获得内容：" + content);  //debug
            String fileDirectory = fileDirectory();
            String fileName = filename(serial);
            download(fileDirectory, fileName, content);
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
