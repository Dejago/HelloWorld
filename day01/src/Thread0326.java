public class Thread0326 {

    public static void main(String[] args) {

        Thread th1 = new Thread(new Runnable() {   //自定义线程的第一种方法，直接新建一个线程对象，再将实现了Runnable接口的类作为参数传入构造器中
            @Override
            public void run() {

                //打印多条信息用于观察多个线程同时运行的效果
                System.out.println("通过实现Runnable建成的线程" + Thread.currentThread().getName() + "启动了！");
                System.out.println("现在时间为：" + System.currentTimeMillis());  //获取当前时间
                System.out.println("当前线程为：" + Thread.currentThread().getName());  //显示调用此方法的线程名是什么
            }

        }, "线程1");  //自定义线程名为线程1

        Thread th2 = new Thread(th1);  //Thread类也继承了Runnable接口，其实例同样可以作为参数传入

        ThreadCustom th3 = new ThreadCustom();

        th1.start(); //会通过线程1调用run方法
        th2.start(); //会通过线程2调用run方法
        th3.start();

        th1.run();  //由main线程直接调用run方法




    }
}

//自定义线程的第二种方法，自定义一个类，继承Thread并重写run方法
class ThreadCustom extends Thread {

    @Override
    public void run() {
        System.out.println("通过继承Thread建成的线程" + Thread.currentThread().getName() + "启动了！");
        System.out.println("现在时间为：" + System.currentTimeMillis());  //获取当前时间
        System.out.println("当前线程为：" + Thread.currentThread().getName());  //显示调用此方法的线程名是什么
    }
}

