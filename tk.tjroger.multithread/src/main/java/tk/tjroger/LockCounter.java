package tk.tjroger;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {
    private int count = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void add(int m) {
        lock.lock();
        try {
            count += m;
            System.out.println(Thread.currentThread().getName() + ": "+count);
        } finally {
            lock.unlock();
        }
    }

    public void signal() {
        condition.signal();
    }

    public void await() {
        try {
            condition.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCount() {
        return count;
    }
}


