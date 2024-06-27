package tk.tjroger.supplies;

import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class FibonacciSupplier implements LongSupplier {
    int a = 0;
    int b = 1;
    Long n = 0L;
    public Long get() {
        a = (int) (n + b);
        n = (long) b;
        b = a;
        return n;
    }

    @Override
    public long getAsLong() {
        a = (int) (n + b);
        n = (long) b;
        b = a;
        return n;
    }
}
