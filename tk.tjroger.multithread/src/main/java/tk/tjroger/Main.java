package tk.tjroger;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        test1();
//        recursiveTest();
//        deadlockTest();
        waitNotifyTest();
//        lockCounterTest();
    }


    public static void lockCounterTest() {
        var lc = new LockCounter();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            var t = new Thread(() -> {
               lc.add(finalI);
//               lc.signal();
            });
            t.start();
        }
        for (int i = 0; i < 5; i++) {
//            lc.await();
        }
        System.out.print(lc.getCount());

    }

    public static void waitNotifyTest() throws InterruptedException {
        var q = new TaskQueue();
        var ts = new ArrayList<Thread>();
        for (int i=0; i<5; i++) {
            var t = new Thread() {
                public void run() {
                    // 执行task:
                    while (true) {
                        String s = q.getTask();
                        System.out.println(Thread.currentThread().getName() + " execute task: " + s);
                    }
                }
            };
            t.start();
            ts.add(t);
        }
        var add = new Thread(() -> {
            for (int i=0; i<10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println(Thread.currentThread().getName() + " add task: " + s);
                q.addTask(s);
                try { Thread.sleep(100); } catch(InterruptedException e) {}
            }
        });
        add.start();
        add.join();
        Thread.sleep(100);
        for (var t : ts) {
            t.interrupt();
        }
    }

    public static void deadlockTest() {
        var deadLock = new DeadLock();
        var t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                deadLock.add(i);
            }
        });

        var t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                deadLock.deadDec(i);
            }
        });
        t1.start();
        t2.start();
    }
   public static void recursiveTest() {
       var counter = new Counter();
       var t1 = new Thread(()-> {
           for (int i = 0; i < 100; i++) {
               counter.add(i);
           }
       });
       var t2 = new Thread(() -> {
           for (int i = 0; i < 100; i++) {
               counter.add(-i);
           }
       });
       t1.start();
       t2.start();
       System.out.println(Thread.currentThread().getName() + ": " + counter.getValue());
   }

    public static void test1() {
        System.out.println("main start...");
        Thread t = new Thread(() -> {
            System.out.println("thread run...");
            System.out.println("thread end.");
        });
        t.start();
        System.out.println("main end...");
    }
}

