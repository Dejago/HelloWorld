public class ThreadProCumTest {
    public static void main(String[] args) {

        int creatorNum = 5;
        int customerNum = 20;

        Thread[] creatorGroup = new Thread[creatorNum];
        Thread[] customerGroup = new Thread[customerNum];

        for (int i = 0; i < creatorNum; i++) {
            creatorGroup[i] = new Thread(new ThreadCreator0328(),"生产者" + (i + 1));
        }

        for (Thread creator : creatorGroup) {
            creator.start();
        }

        for (int i = 0; i < customerNum; i++) {
            customerGroup[i] = new Thread(new ThreadCustomer0328(),"顾客" + (i + 1));
        }

        for (Thread customer : customerGroup) {
            customer.start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
