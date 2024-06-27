package tk.tjroger;

public class Counter {
    private int count = 0;


    public synchronized void add(int n) {
        if (n < 0) {
            dec(-n);
        } else {
            count += n;
        }
        System.out.println(Thread.currentThread().getName() + ": " + count);
    }
    
    public synchronized  void dec(int n) {
        count += n;
        System.out.println(Thread.currentThread().getName() + ": " + count);
    }

    public int getValue() {
        return count;
    }
}

