import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ABQTest0408 {


    public static void main(String[] args) {

        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(5);
        //构造器有三种：
        //1：int   队列的长度
        //2：int boolean  队列长度和是否公平，使用上一个构造器时默认为false
        //3：int boolean Collection    队列长度、公平和初始集合，该集合长度不能大于int否则会抛出IllegalArgumentException
        String receive = null;


        //add添加传入元素到队列中的当前存位putIndex上，会直接调用其父类的offer方法，添加成功会返回true，如果队列是满的会抛出Queue Full
        abq.add("1、add添加的元素");
        //peek会返回当前取位takeIndex上的元素，不会对队列做任何操作
        receive = abq.peek();
        System.out.println(receive);


        try {
            //put添加传入的元素到队列中的当前存位putIndex上，若队列满了会调用await方法阻塞线程，需要处理InterruptedException
            abq.put("2、put添加的元素");
            //take会返回当前取位takeIndex上的元素，并将对应位置的元素变为null，若队列已空则会调用await方法阻塞线程，需要处理InterruptedException
            receive = abq.take();
            System.out.println(receive);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //offer添加传入元素到队列中的当前存位putIndex上，添加成功会返回true，如果队列已满会返回false
        abq.offer("3、offer添加的元素");
        //poll会返回当前取位takeIndex上的元素，并将对应位置的元素变为null，若队列已空则返回null
        receive = abq.poll();
        System.out.println(receive);

        try {
            //额外传入时间长度和TimeUnit类型，offer已满或poll已空时阻塞给定的时间并重试，超时后返回false、null
            abq.offer("4、offer高级版添加的元素", 5, TimeUnit.SECONDS);
            receive = abq.poll(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }



}
