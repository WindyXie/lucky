package windy;

public class MultiThreadFirst {
    // 多个线程同时运行时，线程的调度由操作系统决定，程序本身无法决定。因此，任何一个线程都有可能在任何指令处被操作系统暂停，然后在某个时间段后继续执行。
    // 单线程模型下不存在的问题：多个线程同时读写共享变量，会出现数据不一致的问题。
    // 加锁和解锁之间的代码块称为临界区
    // 一段代码的原子性
    public static void main(String[] args) throws InterruptedException {
        Thread add = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
//                synchronized(Counter.lock) {
                    Counter.count += 1;
//                }
            }
        });
        Thread dec = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
//                synchronized(Counter.lock1) {
                    Counter.count -= 1;
//                }
            }
        });
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
    }
}

class Counter {
    public static final Object lock = new Object();
    public static final Object lock1 = new Object();
    public static int count = 0;
}
