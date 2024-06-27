package tk.tjroger;

public class ThreadTest {
    public static void main(String[] args) {
        System.out.println("main start...");
        Thread t = new Thread(() -> {
            System.out.println("thread run...");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
            System.out.println("thread end.");
        });
        t.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {}
        System.out.println("main end...");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
    }
}