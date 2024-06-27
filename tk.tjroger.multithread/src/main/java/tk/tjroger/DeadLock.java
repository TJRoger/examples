package tk.tjroger;

public class DeadLock {
    Object lockA = new Object();
    Object lockB = new Object();

    int value = 0;
    int other = 0;
    public void add(int m) {
        synchronized (lockA) {
            this.value += m;
            System.out.println(Thread.currentThread().getName() + ": " + value + ","+other);
            synchronized (lockB) {
                this.other += m;
                System.out.println(Thread.currentThread().getName() + ": " + value + ","+other);
            }
        }
    }

    public void deadDec(int m) {
        synchronized (lockB) {
            other -= m;
            System.out.println(Thread.currentThread().getName() + ": " + value + ","+other);

            synchronized (lockA) {
                value -= m;
                System.out.println(Thread.currentThread().getName() + ": " + value + ","+other);

            }
        }
    }

    public void dec(int m) {
        synchronized (lockA) {
            value -= m;
            System.out.println(Thread.currentThread().getName() + ": " + value + ","+other);

            synchronized (lockB) {
                other -= m;
                System.out.println(Thread.currentThread().getName() + ": " + value + ","+other);

            }
        }
    }
}
