package ThreadCreatorAndConsumer;

import java.util.List;

public class ThreadCreator0328 implements Runnable {

    private Object lock;
    private List<String> cargo;
    private boolean isActive;

    public ThreadCreator0328(List<String> cargo, Object lock) {
        this.cargo = cargo;
        this.lock = lock;
        isActive = true;
    }

    @Override
    public void run() {

        //System.out.println("生产者" + Thread.currentThread().getName() + "已启动！当前产品数量为：" + product + getTime());

        int count = 0;

        while (isActive) {
            try {
                Thread.sleep(2000);  //每次生产后休息2秒
            } catch (InterruptedException e) {
                e.printStackTrace();
             //   Thread.currentThread().interrupt();
            }
            addProduct(count);
            System.out.println("生产完毕");
            count++;
        }

        //System.out.println("生产者" + Thread.currentThread().getName() + "已完成生产！当前产品数量为：" + product + getTime());
    }


    private void addProduct(int i) {
        synchronized (lock) {
            cargo.add(Thread.currentThread().getName() + "_hello" + i);
        }
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }


/*

    public static String getTime() {
        return " " + new Date().toString();
    }
*/



}
