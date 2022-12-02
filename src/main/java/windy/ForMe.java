package windy;

public class ForMe {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread-1:running...");
                try {
                    Thread.sleep(1);
                } catch (Exception e) {}
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread-2:running...");
                try {
                    Thread.sleep(1);
                } catch (Exception e) {}
            }
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        for (int i = 0; i < 100; i++) {
            System.out.println("main:running...");
            try {
                Thread.sleep(1);
            } catch (Exception e) {}
        }
    }
}
