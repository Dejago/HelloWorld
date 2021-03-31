public class ThreadCustomer0328 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "已启动！正在进行购物！");
        for (int i = 0; i < 3; i++) {  //每个顾客只购买3个东西！
            try {
                Thread.sleep(3000);  //顾客购物后休息3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ThreadCreator0328.trade();
        }
        System.out.println(Thread.currentThread().getName() + "购物结束！");
    }
}
