import java.util.Date;

public class ThreadCreator0328 implements Runnable {

    private static int product = 0;
    private static final int MAXIMUM_CARGO = 20;
    private static final String LOCK = "LOCK";

    @Override
    public void run() {

        if (product > MAXIMUM_CARGO) {
            product = MAXIMUM_CARGO;
        }
        System.out.println("生产者" + Thread.currentThread().getName() + "已启动！当前产品数量为：" + product + getTime());

        //每个线程生产10次后自动停止
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);  //每次生产后休息2秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            addProduct();
        }

        System.out.println("生产者" + Thread.currentThread().getName() + "已完成生产！当前产品数量为：" + product + getTime());
    }


    private void addProduct() {

        System.out.println(Thread.currentThread().getName() + "正在生产产品!当前库存：" + product + getTime());

        if (product < MAXIMUM_CARGO) {
            synchronized (LOCK) {
                System.out.println(Thread.currentThread().getName() + "生产完成！当前库存：" + ++product + getTime());
            }
        }else {
            synchronized (LOCK) {
                System.out.println("库存已满！" + Thread.currentThread().getName() + "无法生产！当前库存：" + product + getTime());
            }
            while (product == MAXIMUM_CARGO) {
                try {
                    Thread.sleep(1000); //每秒检查一次仓库是否依然是满的，如果是满的则继续待机
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "苏醒！当前货物为：" + product + getTime());
            }
        }


    }

    public synchronized static void trade() {

        System.out.println(Thread.currentThread().getName() + "正在购物！当前货物为：" + product + getTime());

        if (product > 0) {
            synchronized (LOCK) {
                System.out.println(Thread.currentThread().getName() + "消费完成！当前库存为：" + --product + getTime());
            }
        } else {
            synchronized (LOCK) {
                System.out.println(Thread.currentThread().getName() + "无货可买！当前货物为：" + product + getTime());
            }
            while (product == 0) {
                try {
                    Thread.sleep(3000);   //无货供应时每3秒重新检查一次
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "苏醒！当前货物为：" + product + getTime());
            }
        }



    }

    private static String getTime() {
        return " " + new Date().toString();
    }

    public static void setProduct(int i) {
        synchronized (LOCK) {
            if (i < 0) {
                i = 0;
            }else if (i > MAXIMUM_CARGO) {
                i = MAXIMUM_CARGO;
            }
            product = i;
        }
    }

    public static int getProduct() {
        return product;
    }


}
