import java.util.List;

public class ThreadConsumer0328 implements Runnable{

    private List<String> cargo;
    private Object lock;
    private boolean isActive;

    public ThreadConsumer0328(List<String> cargo, Object lock) {
        this.cargo = cargo;
        this.lock = lock;
        isActive = true;
    }

    @Override
    public void run() {
       // System.out.println(Thread.currentThread().getName() + "已启动！正在进行购物！");
        while (isActive) {
            try {
                Thread.sleep(3000);  //顾客购物后休息3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
               // Thread.currentThread().interrupt();
            }
            trade();
        }
   //     System.out.println(Thread.currentThread().getName() + "购物结束！");
    }

    public void trade() {
        String product = null;
        synchronized (lock) {
            if (!cargo.isEmpty()) {
                product = cargo.get(0);
                cargo.remove(0);
            }
        }

        if (product != null) {
            System.out.println(product);
        }

    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}
