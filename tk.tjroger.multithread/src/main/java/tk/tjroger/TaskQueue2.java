package tk.tjroger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskQueue2 {
    Queue<String> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();

    private final Condition condition = lock.newCondition();

    public void addTask(String s) {
        lock.lock();
        try {
            this.queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public  String getTask() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
            return queue.remove();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }  
}
